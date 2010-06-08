package resume.server.guice;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import resume.server.data.ProfileImage;
import resume.server.service.Repository;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;
import com.google.inject.Singleton;

@Singleton
@SuppressWarnings("serial")
public class ImageServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		Repository<ProfileImage> repo = new Repository<ProfileImage>(ProfileImage.class);
		ProfileImage image = repo.loadByUsername( username );
		writeImage( image.getImage() , resp );	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = req.getParameter("username");
		ServletFileUpload upload = new ServletFileUpload();

		try {

			FileItemIterator iter = upload.getItemIterator(req);
			if (iter.hasNext()) {

				FileItemStream item = iter.next();
				InputStream stream = item.openStream();

				ByteArrayOutputStream out = new ByteArrayOutputStream();
				int len;
				byte[] buffer = new byte[8192];
				while ((len = stream.read(buffer, 0, buffer.length)) != -1) {
					out.write(buffer, 0, len);
				}

				byte[] image = resize( out.toByteArray() );
				
				ProfileImage profileImage = getRepo().loadByUsername(username);

				if (profileImage == null) {
					profileImage = new ProfileImage(username, image);
				} else {
					profileImage.setImage(image);
				}

				getRepo().save(profileImage);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected Repository<ProfileImage> getRepo() {
		return new Repository<ProfileImage>(ProfileImage.class);
	}

	protected byte[] resize(byte[] image) {
		Transform size = ImagesServiceFactory.makeResize(300, 300);
		Image img1 = ImagesServiceFactory.makeImage( image );
		Image img2 = ImagesServiceFactory.getImagesService().applyTransform(size,
				img1);
		
		return img2.getImageData();
	}	
	
	protected void writeImage( byte[] image, HttpServletResponse resp ){
		
		try {
			resp.getOutputStream().write( image );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
