package com.Tshirts.ekart.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Tshirts.ekart.dao.CategoryDao;
import com.Tshirts.ekart.dao.ProductDao;
import com.Tshirts.ekart.model.Category;
import com.Tshirts.ekart.model.Product;

@Controller
@RequestMapping("/admin")
public class Adcontrol {
	
	 @Autowired
	 CategoryDao cd;
	 
	 @Autowired
	 ProductDao pd;
	 
	 @RequestMapping("/category")
	 public ModelAndView categorylist(Model m)
	 {
	  
	  Category ca = new Category();
	  m.addAttribute(ca);
	  
	  
	  List<Category> listcat = cd.retrieveAllUsers();
	  m.addAttribute("catlist", listcat);
	  return new ModelAndView("category");
	  
	 }
	 
	 @RequestMapping(value="/catprocess", method= RequestMethod.POST)
		public String addCategory(@ModelAttribute("category") Category ca , Model m)
		{
				System.out.println("cat id ="+ca.getCid());
			if(ca.getCid()!=0)
			{
				cd.update(ca);
			}
			else
			{
				cd.addCreate(ca);
			}
				
				List<Category> listcategories = cd.retrieveAllUsers();
				
				return "redirect:/admin/category";
			
				
		}
	 
	 @RequestMapping(value = "updateCat/{cid}")
		public String updateCategory(@PathVariable("cid")int cid, Model m)
		{
			Category ca = cd.getCategory(cid);
			m.addAttribute("category",ca);
			System.out.println("it is in update category"+ca.getCid());
			
			cd.update(ca);
			m.addAttribute(ca);
			System.out.println("after process "+ca.getCid());
			List<Category> listcategories = cd.retrieveAllUsers();
			m.addAttribute("catlist", listcategories);
			return "category";
			
		}
	 @RequestMapping(value = "deleteCat/{cid}")

		public String deleteCategory(@PathVariable("cid") int cid, Model m) {

			Category c = cd.getCategory(cid);

			cd.delete(c);

			Category ca = new Category();

			m.addAttribute(ca);

			List<Category> listcategories = cd.retrieveAllUsers();

			m.addAttribute("catlist", listcategories);

			return "redirect:/admin/category";

		}
	 
	 @RequestMapping("/product")
		public ModelAndView product(Model m)
		{
			Product pr = new Product();
			m.addAttribute(pr);
			List<Product> listproducts = pd.retrieveAllProducts(); 
			m.addAttribute("prodlist",listproducts);
			List<Category> listcategories = cd.retrieveAllUsers();

			m.addAttribute("catlist", listcategories);


			return  new ModelAndView("product");
		}

	 @RequestMapping(value="/prodprocess", method= RequestMethod.POST)
		public String addCategory(@ModelAttribute("product") Product pr , Model m,@RequestParam("image") MultipartFile mfile,BindingResult result, HttpServletRequest request)
		{
				System.out.println("product id ="+pr.getPid());
				if(pr.getPid()!=0)
				{
					pd.update(pr);
				}
				else
				{
				
						pd.addCreate(pr);
				}
				//multipart file code
				String path = request.getServletContext().getRealPath("/resources/");
				String totalFilewithPath = path + String.valueOf(pr.getPid()) + ".jpg";
				  File productImage = new File(totalFilewithPath);
				  if (!mfile.isEmpty()) {
					   try {
					    byte fileBuffer[] = mfile.getBytes();
					    FileOutputStream fos = new FileOutputStream(productImage);
					    BufferedOutputStream bs = new BufferedOutputStream(fos);
					    bs.write(fileBuffer);
					    bs.close();
					   } catch (Exception e) {
					    m.addAttribute("File Exception", e);
					   }
					  }
					  else {
					   m.addAttribute("error", "problem in uploading image");
					  }


				
				List<Product> listproducts = pd.retrieveAllProducts();
				m.addAttribute("prodlist",listproducts);

				List<Category> listcategories = cd.retrieveAllUsers();
				m.addAttribute("catlist", listcategories);

				return "redirect:/admin/product";
			
				
		}
	 @RequestMapping(value = "updatePat/{pid}")
		public String updateProduct(@PathVariable("pid")int pid, Model m)
		{
			Product pr = pd.getProduct(pid);
			m.addAttribute("product",pr);

			System.out.println("it is in update category"+pr.getPid());
			
			pd.update(pr);
			m.addAttribute(pr);
			System.out.println("after process "+pr.getPid());
			List<Product> listproducts = pd.retrieveAllProducts(); 
			m.addAttribute("prodlist",listproducts);
			return "product";
			
		}
	 @RequestMapping(value = "deletePat/{pid}")

		public String deleteProduct(@PathVariable("pid") int pid, Model m) {

			Product p = pd.getProduct(pid);


			pd.delete(p);

			Product pr = new Product();
			m.addAttribute(pr);

			List<Product> listproducts = pd.retrieveAllProducts(); 
			m.addAttribute("prodlist",listproducts);
			
			List<Category> listcategories = cd.retrieveAllUsers();

			m.addAttribute("catlist", listcategories);

			return "redirect:/admin/product";

		}
	 
	

}
