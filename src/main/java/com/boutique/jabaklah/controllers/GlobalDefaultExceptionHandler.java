package com.boutique.jabaklah.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@ControllerAdvice
public class GlobalDefaultExceptionHandler implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView error() {
        ModelAndView modelAndView = new ModelAndView("404");
        modelAndView.addObject("errorTitle", "page n'est pas trouvée");
        modelAndView.addObject("errorDescription", "nous ne trouvons pas la page que vous recherchez");
        modelAndView.addObject("title", "404 Error Page");
        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return PATH;
    }

    @ExceptionHandler(ProductNotFoundExceptoion.class)
    public ModelAndView errorProductNotfound() {
        ModelAndView modelAndView = new ModelAndView("404");
        modelAndView.addObject("errorTitle", "Ce produit n'est pas disponible");
        modelAndView.addObject("errorDescription", "Le produit que vous recherchez n'est pas disponible en ce moment !");
        modelAndView.addObject("title", "Product Unavailable");
        return modelAndView;
    }

    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
        return "/redirect:/manage/products";

    }

}
