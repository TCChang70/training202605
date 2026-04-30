package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemDAO {
    private List<Item> itemList = new ArrayList<>();

    private static ItemDAO ourInstance = new ItemDAO();

    public static ItemDAO getInstance() {
    	
        return ourInstance;
    }
    
    public Item updateItem(String sku,Item item) {
    	    Optional<Item> opt=itemList.stream().filter(i-> i.getSku().equalsIgnoreCase(sku)).findAny();
    	    if(opt.isPresent()) {
    	    	   Item found=opt.get();
    	    	   found.setName(item.getName());
    	    	   found.setPrice(item.getPrice());
    	    	   item.setSku(sku);
    	    	   return item;
    	    }else
    	    	   return null;
    }

    public void createItem(String sku,String n,BigDecimal p) {
        Item itemToStore = new Item(sku);    
        itemToStore.setPrice(p);
        itemToStore.setName(n);
        itemList.add(itemToStore);
    }

    public boolean itemExists(String sku) {
        for (Item item : itemList) {
            if (item.getSku().equals(sku)) {
                return true;
            }
        }
        return false;
    }


    public List<Item> getItemList() {
        return itemList;
    }

    public Item getItemBySku(String sku) {
        for (Item item : itemList) {
            if (item.getSku().equals(sku)) {
                return item;
            }
        }

        return null;
    }
}

