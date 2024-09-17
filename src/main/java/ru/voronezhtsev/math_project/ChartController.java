package ru.voronezhtsev.math_project;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ChartController {

    private final CoordinateService coordinateService;

    public ChartController(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
    }

    @GetMapping
    public String showCoordinatesPage() {
        return "coordinates";
    }

    @PostMapping("/submit")
    public String handleSubmit(@RequestParam("a") int a,
                               @RequestParam("b") int b,
                               @RequestParam("c") int c,
                               @RequestParam("y") double y,
                               Model model) {

        int result = (int) ((int) (b + Math.sqrt(b * b - 4 * a * c)) / 2 * a);
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("c", c);
        model.addAttribute("result", result);
        coordinateService.setX((int) result);
        coordinateService.setY((int) y);
        return "coordinates";
    }
}
