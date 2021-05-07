import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class BirdSanctuaryTest {

    BirdSanctuary birdSanctuary = BirdSanctuary.getInstance();
    @Test
    public void testBird(){
        //BirdSanctuary birdSanctuary = new BirdSanctuary();
        Penguin penguin = new Penguin();
        birdSanctuary.add(penguin);
        int count = penguin.getCount();
        Assertions.assertEquals(1, count);
    }
    @Test
    public void testBird2() {
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(BirdSanctuaryAddException.class);
        birdSanctuary.add(null);
    }

}