package com.mberendt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mberendt.ModelDao;
import com.mberendt.Model;

public class ModelHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static String INSERT="/model.jsp";
	private static String EDIT = "/edit.jsp";
	private static String MODELRECORD = "/listModel.jsp";
	private ModelDao dao;
	
    public ModelHandler() {
        super();
        dao = new ModelDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
			String redirect="";
			String mid = request.getParameter("id");
			String action = request.getParameter("action");
			
						if((mid!=null) && action.equalsIgnoreCase("insert"))
						{
							int mid2 = Integer.parseInt(mid);
							Model model = new Model();
								model.setId(mid2);
								model.setKolumna1(request.getParameter("kolumna1"));
								model.setKolumna2(request.getParameter("kolumna2"));
								model.setKolumna3(request.getParameter("kolumna3"));
								model.setKolumna4(request.getParameter("kolumna4"));							
								dao.add(model);
							redirect = MODELRECORD;	
							request.setAttribute("models", dao.getAllModels());
								System.out.println("Rekord dodany poprawnie");		
						}
						
						
						else if(action.equalsIgnoreCase("delete"))
						{
							String id = request.getParameter("id");
							int idd = Integer.parseInt(id);  
							dao.remove(idd);
							
							redirect = MODELRECORD;
							request.setAttribute("models", dao.getAllModels());
							System.out.println("Rekord usuniety");
						}
						else if(action.equalsIgnoreCase("editform"))
						{
							redirect = EDIT;
						}
						
						else if (action.equalsIgnoreCase("edit"))
						{
						String id = request.getParameter("id");	
						int idE = Integer.parseInt(id);
						Model model = new Model();
						
							model.setId(idE);
							model.setKolumna1(request.getParameter("Kolumna1"));
							model.setKolumna2(request.getParameter("Kolumna2"));
							model.setKolumna3(request.getParameter("Kolumna3"));
							model.setKolumna4(request.getParameter("Kolumna4"));
							
							dao.edit(model);
							request.setAttribute("model", model);
							redirect = MODELRECORD;
						}
						else if (action.equalsIgnoreCase("listModel"))
						{
							redirect=MODELRECORD;
							request.setAttribute("models", dao.getAllModels());
						}
						else
						{
						redirect=INSERT;
						}
				
				RequestDispatcher rd = request.getRequestDispatcher(redirect);
				rd.forward(request,response);	
	}				


	
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
		{
	        doGet(request, response);
	    }	

}
