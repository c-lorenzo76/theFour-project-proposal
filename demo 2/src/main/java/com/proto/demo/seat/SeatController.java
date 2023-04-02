package com.proto.demo.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author CollinHarris
 */
@Controller
@RequestMapping("/seat")
public class SeatController {
    
    @Autowired
    SeatService seatService;
    
    @GetMapping("/all")
    public String getSeats(Model model) {
        model.addAttribute("seatList", seatService.getAllSeats());
        return "seat/list-seats";
    }

    @GetMapping("/id={SeatId}")
    public String getSeat(@PathVariable long seatId, Model model) {
        model.addAttribute("seat", seatService.getSeat(seatId));
        return "seat/seat-detail";
    }

    @GetMapping("/delete/id={SeatId}")
    public String deleteSeat(@PathVariable long seatId, Model model) {
        seatService.deleteSeat(seatId);
        return "redirect:/seat/all";
    }

    @PostMapping("/create")
    public String createSeat(Seat seat) {

        seatService.saveSeat(seat);
        return "redirect:/seat/all";
    }

    @PostMapping("/update")
    public String upateSeat(Seat seat) {
        seatService.saveSeat(seat);
        return "redirect:/seat/all";
    }

    @GetMapping("/new-seat")
    public String newSeatForm(Model model) {
        return "seat/new-seat";
    }

    @GetMapping("/update/id={seatId}")
    public String updateSeatForm(@PathVariable long seatId, Model model) {
        model.addAttribute("seat", seatService.getSeat(seatId));
        return "seat/update-seat";
    }
}
