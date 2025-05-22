// package Main;

// import Services.StockService;
// import Services.UserService;
// import Services.OrderService;
// import Utils.InputHandler;
// import Utils.DisplayHelper;

// public class StockExchangeApp {
//     private static StockService stockService = new StockService();
//     private static UserService userService = new UserService();
//     private static OrderService orderService = new OrderService();

//     public static void main(String[] args) {
//         while (true) {
//             DisplayHelper.showMainMenu();
//             int choice = InputHandler.getIntInput("Enter choice: ");
//             switch (choice) {
//                 case 1:
//                     userService.registerUser();
//                     break;
//                 case 2:
//                     userService.loginUser();
//                     break;
//                 case 3:
//                     stockService.listAllStocks();
//                     break;
//                 case 4:
//                     orderService.placeBuyOrder();
//                     break;
//                 case 5:
//                     orderService.placeSellOrder();
//                     break;
//                 case 6:
//                     orderService.showMarketDepth();
//                     break;
//                 case 0:
//                     System.out.println("Thank you for using Stock Exchange Terminal!");
//                     System.exit(0);
//                 default:
//                     System.out.println("Invalid choice, try again.");
//             }
//         }
//     }
// }
