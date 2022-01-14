package com.movieticket.movieTicketBooking.repository;

import com.movieticket.movieTicketBooking.entity.Seat;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;

public interface SeatRepo extends JpaRepository<Seat,Integer> {

    public List<Seat> findByAudiIdAndAudiMovieIdAndIsBooked(int audiId,int movieId,int notBooked);


    @Modifying
    @Query("update Seat set booking.id = :bookingId ,isBooked = :isBooked where id in :seatIds")
    public void updateMultipleSeatsWithBookingId(int bookingId, List<Integer> seatIds,int isBooked);

    @Lock(LockModeType.PESSIMISTIC_READ)
//    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "300")})
    @Query("from Seat where  id in :seatIds")
    public List<Seat> forLockingTheSeats(List<Integer> seatIds);
}
