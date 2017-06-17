package db;

import busi.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBOper {
    private String goodsFile;
    // List是一个接口，Goods是泛型
    List<Goods> goods_list;// 存放商品的列表
    List<Provider> provider_list;// 存放供货商的列表
    List<Sale> sale_list;// 存放销售信息的列表
    List<Purchase> purchase_list;
    List<Inventory> inventory_list;
    List<SalesReport> salesReports;

    public DBOper() {
        goods_list = new ArrayList<Goods>();
        provider_list = new ArrayList<Provider>();
        purchase_list = new ArrayList<Purchase>();
        sale_list = new ArrayList<Sale>();
        inventory_list = new ArrayList<Inventory>();
        goodsFile = "e:" + File.separator + "Goods_info.txt";
    }

    public void addInventoryGoodsCount(String goodsNo, int addAmoumt) {
        for (Inventory i : inventory_list) {
            if (i.getGoods_no().equals(goodsNo)) {
                i.setGoods_count(addAmoumt);// addAmount =
                // inventoryAmt+purchaseAmt
                break;
            }
        }
    }

    public void deleteInventoryGoodsCount(String goodsNo, int changeAmount) {
        for (Inventory i : inventory_list) {
            if (i.getGoods_no().equals(goodsNo)) {
                i.setGoods_count(changeAmount);
                break;
            }
        }
    }

    public Goods exactFindGoods(String no) {
        for (Goods g : goods_list) {
            if (g.getGoodsNumber().equals(no)) {
                return g;
            }
        }
        return null;
    }

    public Provider exactFindProvider(String no) {
        for (Provider p : provider_list) {
            if (p.getProvider_no().equals(no)) {
                return p;
            }
        }
        return null;
    }

    public Purchase exactFindPurchase(String no) {
        for (Purchase p : purchase_list) {
            if (p.getGoods_no().equals(no)) {
                return p;
            }
        }
        return null;
    }

    public Sale exactFindSale(String no) {
        for (Sale s : sale_list) {
            if (s.getGoods_no().equals(no)) {
                return s;
            }
        }
        return null;
    }

    public Inventory exactFindInventory(String no) {
        for (Inventory inventory : inventory_list) {
            if (inventory.getGoods_no().equals(no)) {
                return inventory;
            }
        }
        return null;
    }

    public List<Goods> fuzFindGoods(String str) {
        List<Goods> list = new ArrayList<Goods>();
        for (Goods g : goods_list) {
            if (g.getGoods_name().indexOf(str) != -1) {
                list.add(g);
            }
        }
        return list;
    }

    public List<Provider> fuzFindProvider(String str) {
        List<Provider> list = new ArrayList<Provider>();
        for (Provider p : provider_list) {
            if (p.getProvider_name().indexOf(str) != -1) {
                list.add(p);
            }
        }
        return list;
    }

    public List<Inventory> fuzFindInventory(String str) {
        List<Inventory> list = new ArrayList<Inventory>();
        for (Inventory i : inventory_list) {
            if (i.getGoods_name().indexOf(str) != -1) {
                list.add(i);
            }
        }
        return list;
    }

    public int insertGoods(Goods g) {
        goods_list.add(g);
        return 0;
    }

    public int insertProvider(Provider p) {
        provider_list.add(p);
        return 0;
    }

    public int insertPurchase(Purchase p) {
        purchase_list.add(p);
        return 0;
    }

    public int insertSale(Sale s) {
        sale_list.add(s);
        return 0;
    }

    public int insertInventory(Inventory i) {
        inventory_list.add(i);
        return 0;
    }


    public int delGoods(Goods g) {
        for (int i = 0; i < goods_list.size(); i++) {
            String good_no = goods_list.get(i).getGoodsNumber();// 当前对象商品编号
            String del_goods_no = g.getGoodsNumber();// 要删除的商品编号
            if (good_no.equals(del_goods_no)) {
                goods_list.remove(i);
            }
        }
        return 0;
    }

    public int delProvider(Provider p) {
        for (int i = 0; i < provider_list.size(); i++) {
            String provider_no = provider_list.get(i).getProvider_no();// 当前对象供货商编号
            String del_provider_no = p.getProvider_no();// 要删除的供货商编号
            if (provider_no.equals(del_provider_no)) {
                provider_list.remove(i);
            }
        }
        return 0;
    }

    public void editGoodsInfo(String filePath, String goodsNo) {
        //修改商品信息后写入文件
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String str : lines) {
                if (str.startsWith(goodsNo)) {
                    Goods goods = exactFindGoods(goodsNo);//拿到商品
                    String fileString = goods.toFileString();
                    bufferedWriter.write(fileString);
                } else {
                    bufferedWriter.write(str);
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int writeGoodsInfo(String fileName, String content) {
        //字符流 FileReader & FileWriter
        try {
            FileWriter fileWriter = new FileWriter(new File(fileName), true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
//        FileOutputStream fos = new FileOutputStream("e:"+ File.separator+"test.txt");
            bufWriter.write(content + "\r\n");
            bufWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }
        /*
        //用RandomAccessFile方式
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeUTF(content);
            randomFile.close();
        } catch (Exception e) {
            return -1;
        }
        return 0;
        */


    public int loadAllGoods() {
        //用FileInputStream方式
        File file = new File(goodsFile);
        BufferedReader reader = null;
        try {
//                reader = new BufferedReader(new FileReader(file));
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String goodsInfo = null;
            while ((goodsInfo = reader.readLine()) != null) {
                String[] arrTmp = goodsInfo.split("[,，]");
                Goods g = createGoods(arrTmp);
                goods_list.add(g);
            }
            reader.close();
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    /*
     //用RandomAccessFile方式
    try {
            RandomAccessFile rdf = new RandomAccessFile(f, "r");
            String tmp = "";
            while ((tmp = rdf.readLine()) != null) {
                String goodsInfo = new String(tmp.getBytes("ISO-8859-1"), "UTF-8");
                String[] arrTmp = goodsInfo.split("，");
                Goods g = createGoods(arrTmp);
                goods_list.add(g);
            }
            rdf.close();
        } catch (Exception e) {
            return -1;
        }
    */


    private Goods createGoods(String[] goodsInfo) {
        String goods_no = new String(goodsInfo[0]);
        String goods_name = new String(goodsInfo[1]);
        String goods_unit = new String(goodsInfo[2]);
        String goods_status = new String(goodsInfo[3]);
        int quality_days = Integer.parseInt(goodsInfo[4]);
        return new Goods(goods_no, goods_name, goods_unit, goods_status, quality_days);
    }

    public int prtAllGoods() {
        for (Goods g : goods_list) {
            System.out.println(g.toString());
        }
        return 0;
    }

    public int prtAllProvider() {
        for (Provider p : provider_list) {
            System.out.println(p.toString());
        }
        return 0;
    }

    public int prtAllPurchase() {
        for (Purchase p : purchase_list) {
            System.out.println(p.toString());
        }
        return 0;
    }

    public int prtAllSale() {
        for (Sale s : sale_list) {
            System.out.println(s.toString());
        }
        return 0;
    }

    public int prtAllInventory() {
        for (Inventory i : inventory_list) {
            System.out.println(i.toString());
        }
        return 0;
    }


    public List<Inventory> getInventory_list() {
        return inventory_list;
    }

    public void setInventory_list(List<Inventory> inventory_list) {
        this.inventory_list = inventory_list;
    }

    public List<Goods> getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(List<Goods> goods_list) {
        this.goods_list = goods_list;
    }

    public List<Provider> getProvider_list() {
        return provider_list;
    }

    public void setProvider_list(List<Provider> provider_list) {
        this.provider_list = provider_list;
    }

    public List<Sale> getSale_list() {
        return sale_list;
    }

    public void setSale_list(List<Sale> sale_list) {
        this.sale_list = sale_list;
    }

    public List<Purchase> getPurchase_list() {
        return purchase_list;
    }

    public void setPurchase_list(List<Purchase> purchase_list) {
        this.purchase_list = purchase_list;
    }

    public String getGoodsFile() {
        return goodsFile;
    }

    public void setGoodsFile(String goodsFile) {
        this.goodsFile = goodsFile;
    }
}
