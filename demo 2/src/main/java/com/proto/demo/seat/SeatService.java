package com.proto.demo.seat;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author CollinHarris
 */
@Service
public class SeatService {
    
    @Autowired
    private SeatRepository repo;

    public List<Seat> getAllSeats(){
        return repo.findAll(); 
    }
    
    public Seat getSeat(long SeatId){
        return repo.getReferenceById(SeatId);
    }
    public void deleteSeat(long SeatId){
        repo.deleteById(SeatId);
    }
    public void saveSeat(Seat seat){
        repo.save(seat);
    }
}
