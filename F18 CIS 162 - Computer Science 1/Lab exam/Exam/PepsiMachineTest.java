import org.junit.*;

/**
 * Unit tests for PepsiMachine
 *
 * @author Ana Posada
 * @version - November 2018
 */
public class PepsiMachineTest
{

    @Test
    public void constructorSetsUnits() 
    {
        PepsiMachine mine= new PepsiMachine(10);
        Assert.assertEquals(10, mine.getInventory());
    }

    @Test
    public void constructorSetsSales()
    {
        PepsiMachine mine = new PepsiMachine(10);
        Assert.assertEquals(0, mine.getTotalSales());
    }

    @Test
    public void constructorSetsCredit()
    {
        PepsiMachine mine = new PepsiMachine(10);
        Assert.assertEquals(0, mine.getCredit());
    }

    @Test
    public void testGetPrice()
    {
        PepsiMachine mine = new PepsiMachine(10);
        Assert.assertEquals(150, mine.getPrice());

    }

    @Test
    public void testGetInventory()
    {
        PepsiMachine mine = new PepsiMachine(20);
        Assert.assertEquals(20, mine.getInventory());
    }

    @Test
    public void insertCoinValid()
    {
        PepsiMachine mine = new PepsiMachine(10);
        mine.insertCoin(5);
        mine.insertCoin(10);
        mine.insertCoin(25);
        mine.insertCoin(100);
        Assert.assertEquals(140, mine.getCredit());
    }

    @Test
    public void insertCoinInvalid()
    {
        PepsiMachine mine = new PepsiMachine(10);
        mine.insertCoin(7);
        mine.insertCoin(-8);
        Assert.assertEquals(0, mine.getCredit());
    }

    @Test
    public void insertCoinNoUnits()
    {
        PepsiMachine mine = new PepsiMachine(0);
        mine.insertCoin(5);
        mine.insertCoin(10);
        Assert.assertEquals(0, mine.getCredit());
    }

    @Test
    public void makeSelectionOkMoney()
    {
        PepsiMachine mine = new PepsiMachine(10);
        mine.insertCoin(100);
        mine.insertCoin(25);
        mine.insertCoin(25);
        mine.makeSelection();
        Assert.assertEquals(0, mine.getCredit());
        Assert.assertEquals(9, mine.getInventory());
        Assert.assertEquals(150, mine.getTotalSales());
    }

    @Test
    public void makeSelectionChange()
    {
        PepsiMachine mine = new PepsiMachine(10);
        mine.insertCoin(100);
        mine.insertCoin(25);
        mine.insertCoin(25);
        mine.insertCoin(25);
        mine.makeSelection();
        Assert.assertEquals(0, mine.getCredit());
        Assert.assertEquals(9, mine.getInventory());
        Assert.assertEquals(150, mine.getTotalSales());
    }

    @Test
    public void makeSelectionMoreMoneyNeeded()
    {
        PepsiMachine mine = new PepsiMachine(10);
        mine.insertCoin(100);
        mine.insertCoin(25);
        mine.makeSelection();
        Assert.assertEquals(125, mine.getCredit());
        Assert.assertEquals(10, mine.getInventory());
        Assert.assertEquals(0, mine.getTotalSales());
    }

    @Test
    public void restockValid()
    {
        PepsiMachine mine = new PepsiMachine(10);
        mine.restock(5);
        Assert.assertEquals(15, mine.getInventory());
    }

    @Test
    public void restockInvalid()
    {
        PepsiMachine mine = new PepsiMachine(10);
        mine.restock(-5);
        Assert.assertEquals(10, mine.getInventory());
    }

    @Test
    public void cancelPurchase()
    {
        PepsiMachine mine = new PepsiMachine(10);
        mine.insertCoin(100);
        mine.insertCoin(25);
        mine.cancelPurchase();     
        Assert.assertEquals(0, mine.getCredit());
    }

    @Test
    public void multipleSales()
    {
        PepsiMachine mine = new PepsiMachine(10);
        mine.multipleSales(10);
        Assert.assertEquals(1500, mine.getTotalSales());
        Assert.assertEquals(0, mine.getInventory());
    }

    @Test
    public void multipleSalesUnitsRunOut()
    {
        PepsiMachine mine = new PepsiMachine(10);
        mine.multipleSales(20);
        Assert.assertEquals(1500, mine.getTotalSales());
        Assert.assertEquals(0, mine.getInventory());
    }
}
