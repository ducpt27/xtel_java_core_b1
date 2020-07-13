package com.xtel.training.io_config.config_xml.b2_electric;

import com.xtel.training.common.utils.NumberUtils;
import com.xtel.training.common.utils.XMLUtils;
import com.xtel.training.io_config.config_xml.b2_electric.model.ElectricBill;

import java.util.Scanner;

public class BaiTap2 {

    //Đường dẫn thư mục dự án
    private static final String SRC_PATH = System.getProperty("user.dir");
    //Đường dẫn file config price electric milestone
    private static String FILE_PATH = SRC_PATH + "\\config\\price_electric.xml";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        //Lấy số điện từ console
        System.out.println("Nhập số điện:");
        Integer electricNum = NumberUtils.parseInt(SCANNER.nextLine());
        if (electricNum == null || electricNum < 0) {
            System.out.println("Nhập sai số điện!");
            return;
        }

        ElectricBill electricBill;
        //Lấy giá điện từng mốc từ file config
        try {
            electricBill = (ElectricBill) XMLUtils.toObject(new ElectricBill(), FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        electricBill.setEletricNum(electricNum);
        //Lấy tổng tiền điện và hiển thị
        Double electricTotalPrice = electricBill.getTotalPrice();
        if (electricTotalPrice != null) {
            System.out.println("Tổng tiền điện: " + electricTotalPrice + "đ");
        }
        electricBill.getTotalPrice();
    }
}