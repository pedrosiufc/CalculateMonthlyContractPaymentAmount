package services;

import java.time.temporal.TemporalAmount;

public interface OnlinePaymentService {

	double paymentFee(double amount);
	double interest(double amount, int months);
		
}
