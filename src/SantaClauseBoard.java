import enumeration.DeliveryStatus;
import model.Order;
import model.Present;
import utils.FileUtils;
import utils.StringUtils;

import java.util.*;

public class SantaClauseBoard {
    private static HashMap<String, Order> nationOrderHashMap;


    /**
     * Set up Santa Clause board
     */
    public SantaClauseBoard() {
        // Load files into memory and stores values in a HashMap

        nationOrderHashMap = new LinkedHashMap<>();

        FileUtils presentFile = new FileUtils("present.txt");
        FileUtils presentNationNumFile = new FileUtils("presentNationNum.txt");
        List<String> presentNationNumList = presentNationNumFile.lines;

        int j = 0;

        // Iterates the number of times indicated in the second column of presentNationNum.txt for each nation
        for(String presentNationNum: presentNationNumList) {
            int numOfPresents = Integer.parseInt(FileUtils.getColumns(presentNationNum).get(1));
            List<Present> presentList = new ArrayList<>();

            for(int i = 0; i < numOfPresents; i++) {

                List<String> lineColumns = FileUtils.getColumns(presentFile.lines.get(j+i));

                Present p = new Present();

                p.setNation(lineColumns.get(0));
                p.setStreet1(lineColumns.get(1));
                p.setStreet2(lineColumns.get(2));
                p.setCity(lineColumns.get(3));
                p.setId(j+i);

                presentList.add(p);
            }
            Order order = new Order();
            order.setPresentList(presentList);

            nationOrderHashMap.put(order.getPresentList().get(0).getNation(), order);
            j += numOfPresents;

        }

    }


    public static void main(String[] args) {

        // Initializes Santa Clause Board
        SantaClauseBoard santaClauseBoard = new SantaClauseBoard();

        String input = "";
        do {
            System.out.println("1) Show delivery status");
            System.out.println("2) Prepare Order");
            System.out.println("3) Send Order/Deliver");
            System.out.println("4) Ready to Serve");
            System.out.println("5) Exit");
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();


            if("1".equals(input)) {
                for(String key : nationOrderHashMap.keySet()) {
                    System.out.println(StringUtils.formatString(key, String.valueOf(nationOrderHashMap.get(key).getPresentList().size()), nationOrderHashMap.get(key).getDeliveryStatus().toString()));
                }
            }
            else
            if("2".equals(input)) {
                Order order = null;
                do {
                    input = scanner.nextLine();
                    order = nationOrderHashMap.get(input);
                    if(order == null) {
                        System.out.println("The input provided does not match any country");
                    }
                } while (order == null);

                order.setDeliveryStatus(DeliveryStatus.IN_PREPARATION);
            }
            else
            if("3".equals(input)) {
                for(Order order : nationOrderHashMap.values()) {
                    order.setDeliveryStatus(DeliveryStatus.IN_DELIVERY);
                }
            }
            else
            if("4".equals(input)) {
                for(Order order : nationOrderHashMap.values()) {
                    order.setDeliveryStatus(DeliveryStatus.DELIVERED);
                }
            }
        } while (!input.equals("5"));
    }
}