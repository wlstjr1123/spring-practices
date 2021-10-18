package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.repository.GuestBookRepository;
import com.douzone.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {
	@Autowired
	private GuestBookRepository guestBookRepository;
	
	@RequestMapping("")
	public String main(Model model) {
		List<GuestBookVo> list = guestBookRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestBookVo vo) {
		guestBookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{no}")
	public String deleteform(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestBookVo vo) {
		guestBookRepository.delete(vo);
		return "redirect:/";
	}
}
