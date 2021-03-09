public class MyDemoTest {
    @Test
    public static void defaultTest(){
        System.out.println("defaultTest");
    }
    @AfterSuite
    public static void afterTest() {
        System.out.println("After Test");
    }
    @Test(value = 1)
    public static void oneTest(){
        System.out.println("Test value =1");
    }
    @BeforeSuite
    public static void deforeTest(){
        System.out.println("Before Test");
    }
    @Test(value = 6)
    public static void sixTest(){
        System.out.println("Test value =6");
    }
    @Test(value = 10)
    public static void tenTest(){
        System.out.println("Test value =10");
    }
}
