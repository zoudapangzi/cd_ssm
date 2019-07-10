package controller;

import com.github.pagehelper.PageInfo;
import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/save")
    public String save(Product product)throws Exception{
        productService.save(product);
        return "redirect:findAll";
    }

    /**
     * 查询所有产品方法
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required =true, defaultValue = "1") Integer page, @RequestParam(name = "size", required =true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Product> products = productService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(products);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;

    }
}
