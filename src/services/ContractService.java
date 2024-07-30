package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		
		double basecQuota=contract.getTotalValue()/months;
		
		// i indo de 1 até a quantidade de menses informados
		for(int i=1; i<= months; i++) {
			LocalDate dueDate= contract.getDate().plusMonths(i);
			
		double interest=onlinePaymentService.interest(basecQuota, i);
		double fee=onlinePaymentService.paymentFee(basecQuota + interest);
		double quota = basecQuota + interest + fee;	
		
		
		contract.getInstallments().add(new Installment(dueDate, quota));
		
	
		}
		
	}

}
