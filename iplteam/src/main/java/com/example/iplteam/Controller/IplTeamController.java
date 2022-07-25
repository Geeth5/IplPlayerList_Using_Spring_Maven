package com.example.iplteam.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.iplteam.domain.players;
import com.example.iplteam.Service.IplService;

@Controller
public class IplTeamController {
	
	 @Autowired
	    private IplService service;

	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        List<players> listplayers = service.listAll();
	        model.addAttribute("listplayers", listplayers);
			System.out.println(listplayers);
	        System.out.print("Get / ");	
	        return "index";
	    }

	    @GetMapping("/new")
	    public String add(Model model) {
	        model.addAttribute("players", new players());
	        return "new";
	    }

	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveStudent(@ModelAttribute("players") players std) {
	        service.save(std);
	        return "redirect:/";
	    }

	    @RequestMapping("/edit/{id}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("new");
	        players std = service.get(id);
	        mav.addObject("players", std);
	        return mav;
	    }

	    @RequestMapping("/delete/{id}")
	    public String deletestudent(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/";
	    }
}
