package database;

import business.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperator {
    private String goodsFile;
    // List是一个接口，Goods是泛型
    private List<Goods> goodsList;// 存放商品的列表
    private List<Provider> providerList;// 存放供货商的列表
    private List<Sale> saleList;// 存放销售信息的列表
    private List<Purchase> purchaseList;
    private List<Inventory> inventoryList;
    List<SalesReport> salesReports;

    public DatabaseOperator() {
        goodsList = new ArrayList<>();
        providerList = new ArrayList<>();
        purchaseList = new ArrayList<>();
        saleList = new ArrayList<>();
        inventoryList = new ArrayList<>();
        goodsFile = "e:" + File.separator + "Goods_info.txt";
    }

    public void addInventoryGoodsCount(String goodsNo, int addAmount) {
        for (Inventory i : inventoryList) {
            if (i.getGoodsNumber().equals(goodsNo)) {
                i.setGoodsCount(addAmount);// addAmount =
                // inventoryAmt+purchaseAmt
                break;
            }
        }
    }

    public void deleteInventoryGoodsCount(String goodsNo, int changeAmount) {
        for (Inventory i : inventoryList) {
            if (i.getGoodsNumber().equals(goodsNo)) {
                i.setGoodsCount(changeAmount);
                break;
            }
        }
    }

    public Goods exactFindGoods(String no) {
        for (Goods g : goodsList) {
            if (g.getGoodsNumber().equals(no)) {
                return g;
            }
        }
        return null;
    }

    public Provider exactFindProvider(String no) {
        for (Provider p : providerList) {
            if (p.getProviderNumber().equals(no)) {
                return p;
            }
        }
        return null;
    }

    public Purchase exactFindPurchase(String no) {
        for (Purchase p : purchaseList) {
            if (p.getGoodsNumber().equals(no)) {
                return p;
            }
        }
        return null;
    }

    public Sale exactFindSale(String no) {
        for (Sale s : saleList) {
            if (s.getGoodsNumber().equals(no)) {
                return s;
            }
        }
        return null;
    }

    public Inventory exactFindInventory(String no) {
        for (Inventory inventory : inventoryList) {
            if (inventory.getGoodsNumber().equals(no)) {
                return inventory;
            }
        }
        return null;
    }

    public List<Goods> fuzFindGoods(String str) {
        List<Goods> list = new ArrayList<Goods>();
        for (Goods g : goodsList) {
            if (g.getGoodsName().contains(str)) {
                list.add(g);
            }
        }
        return list;
    }

    public List<Provider> fuzFindProvider(String str) {
        List<Provider> list = new ArrayList<Provider>();
        for (Provider p : providerList) {
            if (p.getProviderName().contains(str)) {
                list.add(p);
            }
        }
        return list;
    }

    public List<Inventory> fuzFindInventory(String str) {
        List<Inventory> list = new ArrayList<Inventory>();
        for (Inventory i : inventoryList) {
            if (i.getGoodsName().contains(str)) {
                list.add(i);
            }
        }
        return list;
    }

    public int insertGoods(Goods g) {
        goodsList.add(g);
        return 0;
    }

    public int insertProvider(Provider provider) {
        providerList.add(provider);
        return 0;
    }

    public int insertPurchase(Purchase purchase) {
        purchaseList.add(purchase);
        return 0;
    }

    public int insertSale(Sale sale) {
        saleList.add(sale);
        return 0;
    }

    public int insertInventory(Inventory inventory) {
        inventoryList.add(inventory);
        return 0;
    }


    public int delGoods(Goods goods) {
        for (int i = 0; i < goodsList.size(); i++) {
            String good_no = goodsList.get(i).getGoodsNumber();// 当前对象商品编号
            String del_goods_no = goods.getGoodsNumber();// 要删除的商品编号
            if (good_no.equals(del_goods_no)) {
                goodsList.remove(i);
            }
        }
        return 0;
    }

    public int delProvider(Provider p) {
        for (int i = 0; i < providerList.size(); i++) {
            String provider_no = providerList.get(i).getProviderNumber();// 当前对象供货商编号
            String del_provider_no = p.getProviderNumber();// 要删除的供货商编号
            if (provider_no.equals(del_provider_no)) {
                providerList.remove(i);
            }
        }
        return 0;
    }

    public void editGoodsInfo(String filePath, String goodsNumber) {
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
                if (str.startsWith(goodsNumber)) {
                    Goods goods = exactFindGoods(goodsNumber);//拿到商品
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
                goodsList.add(g);
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
                goodsList.add(g);
            }
            rdf.close();
        } catch (Exception e) {
            return -1;
        }
    */


    private Goods createGoods(String[] goodsInfo) {
        String goodsNumber = goodsInfo[0];
        String goodsName = goodsInfo[1];
        String goodsUnit = goodsInfo[2];
        String goodsStatus = goodsInfo[3];
        int qualityDays = Integer.parseInt(goodsInfo[4]);
        return new Goods(goodsNumber, goodsName, goodsUnit, goodsStatus, qualityDays);
    }

    public int printAllGoods() {
        for (Goods g : goodsList) {
            System.out.println(g.toString());
        }
        return 0;
    }

    public int printAllProvider() {
        for (Provider p : providerList) {
            System.out.println(p.toString());
        }
        return 0;
    }

    public int printAllPurchase() {
        for (Purchase p : purchaseList) {
            System.out.println(p.toString());
        }
        return 0;
    }

    public int printAllSale() {
        for (Sale s : saleList) {
            System.out.println(s.toString());
        }
        return 0;
    }

    public int printAllInventory() {
        for (Inventory i : inventoryList) {
            System.out.println(i.toString());
        }
        return 0;
    }


    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    public void setProviderList(List<Provider> providerList) {
        this.providerList = providerList;
    }

    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public String getGoodsFile() {
        return goodsFile;
    }

    public void setGoodsFile(String goodsFile) {
        this.goodsFile = goodsFile;
    }
}
