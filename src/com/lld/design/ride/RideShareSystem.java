package com.lld.design.ride;

import java.util.List;

public class RideShareSystem {
	
	int drivers;
	List<Rider> riders;
	
	public RideShareSystem(int drivers, List<Rider> riders) {
		if(drivers < 2 || riders.size() < 2) {
			System.out.println("Not enough dirvers or riders");
		}
		this.drivers = drivers;
		this.riders = riders;
	}
		 
	void createRide (int riderId, int rideId, int origin, int destination, int seats) {
		if(drivers == 0) {
			System.out.println("No drivers around can not create ride");
		}
		for(Rider rider : riders) {
			if(rider.getId() == riderId) {
				rider.createRide(rideId, origin, destination, seats);
				drivers--;
				break;
			}
		}
	}
	
	void updateRide (int riderId, int rideId, int origin, int destination, int seats){
		for(Rider rider : riders) {
			if(rider.getId() == riderId) {
				rider.updateRide(rideId, origin, destination, seats);
				break;
			}
		}
	}
	
	void withdrawRide (int riderId, int rideId) {
		for(Rider rider : riders) {
			if(rider.getId() == riderId) {
				rider.withdrawRide(rideId);
				drivers++;
				break;
			}
		}
	}
	
	int closeRide(int riderId) {
		for(Rider rider : riders) {
			if(rider.getId() == riderId) {
				drivers++;
				return rider.closeRide();
			}
		}
		return 0;
	}


}
