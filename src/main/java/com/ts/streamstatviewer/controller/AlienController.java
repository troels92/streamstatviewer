package com.ts.streamstatviewer.controller;

import com.ts.streamstatviewer.model.Alien;
import com.ts.streamstatviewer.repository.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlienController {

    @Autowired
    AlienRepo repo;

    //Show frontpage
        @RequestMapping("/")
        public String index()
        {
            return "index";
        }

    //Crud functions used from AlienRepo extends JpaRepository

        //Create
            //showing page
            @RequestMapping("/createAlien")
            public String createAlien()
            {
                return "createAlien";
            }

            //Executing save
            @RequestMapping("/addAlien")
            public String addAlien(Alien alien)
            {
                repo.save(alien);
                return "index";
            }

        //Read
            //Get all
            @RequestMapping("/AllAliens")
            public String AllAliens(Model model)
            {
                model.addAttribute("AllAliens", repo.findAll());
                return "AllAliens";
            }

            //Get by id
                //Showing searchpage
                @RequestMapping("/Alien")
                public String Alien()
            {
                return "Alien";
            }

                //Executing get func
                @GetMapping("/getAlien")
                public ModelAndView getAlien(@RequestParam int aid)
                {
                    ModelAndView mv = new ModelAndView("AlienResult");
                    Alien alien = repo.findById(aid).orElse(new Alien());
                    mv.addObject(alien);
                    return mv;
                }

        //Update
            @RequestMapping("/editAlien")
            public ModelAndView editAlien(@RequestParam int aid) {

                ModelAndView mv = new ModelAndView("editAlien");
                Alien alien = repo.findById(aid).orElse(new Alien());
                mv.addObject(alien);
                return mv;
            }

        //Delete

            //Getting data to vertify for delete
                @RequestMapping("/deleteAlien")
                public ModelAndView deleteAlien(@RequestParam int aid)
                {
                    ModelAndView mv = new ModelAndView("deleteAlien");
                    Alien alien = repo.findById(aid).orElse(new Alien());
                    mv.addObject(alien);
                    return mv;
                }
            //execute delete
                @PostMapping("/deleteAlien/{aid}")
                public void delete(@PathVariable int aid) {
                    repo.deleteById(aid);
                }


}
