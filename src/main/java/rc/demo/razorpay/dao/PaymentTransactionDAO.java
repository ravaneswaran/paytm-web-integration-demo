package rc.demo.razorpay.dao;

import javax.persistence.Query;

import rc.demo.razorpay.models.PaymentTransaction;

import java.util.List;

public class PaymentTransactionDAO extends AbstractDAO<PaymentTransaction>{

    public PaymentTransactionDAO(){
        super(PaymentTransaction.class);
    }

    @SuppressWarnings("unchecked")
	public List<PaymentTransaction> list(){
        Query query = this.getEntityManager().createQuery("SELECT pt FROM PaymentTransaction AS pt");
        return query.getResultList();
    }

}
