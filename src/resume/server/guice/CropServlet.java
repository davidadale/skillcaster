package resume.server.guice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;
import com.google.inject.Singleton;

import resume.server.data.ProfileImage;
import resume.server.service.Repository;

@Singleton
@SuppressWarnings("serial")
public class CropServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = req.getParameter("username");
		ProfileImage image = getRepo().loadByUsername(username);
		writeImage(image.getCroppedImage(), resp);

	}

	protected void writeImage(byte[] image, HttpServletResponse resp) {

		try {
			resp.getOutputStream().write(image);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = req.getParameter("username");
		String x1 = req.getParameter("x1");
		String y1 = req.getParameter("y1");
		String x2 = req.getParameter("x2");
		String y2 = req.getParameter("y2");
		String width = req.getParameter("width");
		String height = req.getParameter("height");
		
		ProfileImage profileImage = getRepo().loadByUsername(username);

		if (profileImage != null) {

			profileImage.setCroppedImage(createCrop(profileImage.getImage(),
					Double.parseDouble(x1), Double.parseDouble(y1), Double
							.parseDouble(x2), Double.parseDouble(y2),
							Double.parseDouble(width),Double.parseDouble(height)));

			getRepo().save(profileImage);

		}

	}

	public byte[] createCrop(byte[] image, double x1, double y1, double x2,
			double y2, double width, double height) {

		Transform crop = ImagesServiceFactory.makeCrop(x1/width, y1/height, x2/width, y2/height);

		Image cropped = ImagesServiceFactory.getImagesService().applyTransform(
				crop, ImagesServiceFactory.makeImage(image));

		return cropped.getImageData();
	}

	protected Repository<ProfileImage> getRepo() {
		return new Repository<ProfileImage>(ProfileImage.class);
	}

}
