package com.movieticket.movieTicketBooking.repository;

import com.movieticket.movieTicketBooking.entity.Seat;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;

public interface SeatRepo extends JpaRepository<Seat,Integer> {

    public List<Seat> findByAudiIdAndAudiMovieIdAndIsBookedAndIsReserved(int audiId,int movieId,int notBooked,int isReserved);

//                not being used
//    @Modifying
//    @Query("update Seat set booking.id = :bookingId ,isBooked = :isBooked, version = (version+1) where id in :seatIds")
//    public void updateMultipleSeatsWithBookingId(int bookingId, List<Integer> seatIds,int isBooked);

    //These contents are for implementing pessimistic locking
//    @Transactional
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "30000")})

    @Query("from Seat where  id in :seatIds")
    public List<Seat> getListOfSeatsToBeBooked(List<Integer> seatIds);

    @Modifying
    @Query("update Seat set isReserved = :reserveToggle where id in :seatIds")
    public void reserveToggleSeat( List<Integer> seatIds, int reserveToggle);

}
