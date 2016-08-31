import com.clara.CreditCard;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


public class CreditCardTest {

    @Test
    public void testIsCreditCardValid(){
        //Some valid credit card numbers
        assertTrue("4123123412341236 should be valid", CreditCard.isValidCreditCard("4"));
        assertTrue("4000111122223339 should be valid", CreditCard.isValidCreditCard("4"));
        assertTrue("4123456789012349 should be valid", CreditCard.isValidCreditCard("4"));
        //Invalid - too short
        assertFalse("4445556666 should be invalid - too short", CreditCard.isValidCreditCard("444"));
        assertFalse("444555666677777 should be invalid - too short", CreditCard.isValidCreditCard("444"));

        //Invalid - doesn't start with 4
        assertFalse("5123189756461236 should be invalid - doesn't start with 4", CreditCard.isValidCreditCard("5"));

        //Invalid - check digit wrong
        assertFalse("4567568658341240 should be invalid - check digit is wrong", CreditCard.isValidCreditCard("5"));
        assertFalse("4658907842345226 should be invalid - check digit is wrong", CreditCard.isValidCreditCard("5"));
        assertFalse("4904563343456566 should be invalid - check digit is wrong", CreditCard.isValidCreditCard("5"));

    }


}
