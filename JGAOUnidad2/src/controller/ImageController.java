package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.ImageDOM;
import model.Image;



/**
 * Servlet implementation class ImageController
 */
@WebServlet("/ImageController")
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Image image;
	private List<Image> images;
	private ImageDOM imageDOM;
	private List<String> ids = new ArrayList<String>();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageController() {
        super();
        // TODO Auto-generated constructor stub
        image = new Image();
        images = new ArrayList<Image>();
        imageDOM = new ImageDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
			image.setCategory(request.getParameter("category"));
			image.setType(request.getParameter("type"));
		
			
			try {
				
				image.setHeight(Integer.parseInt(request.getParameter("height")));
			}catch(NumberFormatException e) {
				image.setHeight(25);
				
				
			}
			
			if(image.getId()=="") {
				int id = 1;
				String newId= "soc"+String.format("%05d", 1);
				image.setId(newId);
				
				if (images.size()>0) {
					ids.clear();
					for (Image p: images) {
						ids.add(p.getId());
					}
					for (int i=0; i<= ids.size(); i++){
						newId= "soc"+ String.format("%05d", i+1);
						
						if (! ids.contains(newId)) {
						image.setId(newId);
						break;
						}
					}
				}
				imageDOM.add(image);
			}else {
				imageDOM.update(image);
			}
			images = imageDOM.getImages();
			request.setAttribute("images", images);
			request.getRequestDispatcher("image_list.jsp").forward(request, response);
			
			
			
		}else if (request.getParameter("btn_new")!=null) {
			image = new Image();
			request.getRequestDispatcher("image_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				String id = request.getParameter("id");
				image = imageDOM.findById(id);
				
			}catch (Exception e) {
				
				image = new Image();
			}
			request.setAttribute("image", image);
			
			request.getRequestDispatcher("image_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			String id = request.getParameter("id");
			imageDOM.delete(id);
			images = imageDOM.getImages();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("images", images);
			request.getRequestDispatcher("image_list.jsp").forward(request, response);
		}else {
			images = imageDOM.getImages();
			request.setAttribute("images", images);
			request.getRequestDispatcher("image_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
