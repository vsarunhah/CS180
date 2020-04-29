import javax.swing.*;
import java.util.Optional;

/**
 * An add controller of a product inventory application.
 *
 * <p>CS18000 -- Summer 2019 -- Complex GUIs -- Homework</p>
 */
public final class AddController {
    /**
     * The inventory model of this add controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The add view of this add controller.
     */
    private AddView addView;

    /**
     * Constructs a newly allocated {@code AddController} object with the specified inventory model and add view.
     *
     * @param inventoryModel the inventory model of this add controller
     * @param addView        the add view of this add controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code addView} argument is
     *                                  {@code null}
     */
    public AddController(InventoryModel inventoryModel, AddView addView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (addView == null) {
            throw new IllegalArgumentException("addView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.addView = addView;

            this.addView.getAddButton().addActionListener(e -> this.getAddButtonSemantics());

            this.addView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //AddController

    private static boolean isParsable(String string) {
        try{
            double num = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Gets the semantics of an add view's add button.
     */
    private void getAddButtonSemantics() {
        String sku;
        String name;
        int quantity;
        double retail;
        double wholesale;
        String issue = "";
        if (!isParsable(addView.getSkuTextField().getText())) {
            issue = "SKU";
        } else if (!isParsable(addView.getQuantityTextField().getText())) {
            issue = "quantity";
        } else if (!isParsable(addView.getRetailPriceTextField().getText())) {
            issue = "retail price";
        } else if (!isParsable(addView.getWholesalePriceTextField().getText())) {
            issue = "wholesale price";
        }
        if (issue.equals("")) {
            try {
                double skuD = Double.parseDouble(addView.getSkuTextField().getText());
            } catch (NumberFormatException e) {
                issue = "SKU";
            }
        }
        if(issue.equals("")) {
            try {
                int quantityI = Integer.parseInt(addView.getQuantityTextField().getText());
            } catch (NumberFormatException e) {
                issue = "quantity";
            }
        }
        if(issue.equals("")){
            try{
                double retailD = Double.parseDouble(addView.getRetailPriceTextField().getText());
            } catch (NumberFormatException e) {
                issue = "retail price";
            }
        }
        if(issue.equals("")){
            try{
                double wholesaleD = Double.parseDouble(addView.getWholesalePriceTextField().getText());
            } catch (NumberFormatException e) {
                issue = "wholesale price";
            }
        }
        if (!issue.equals("")) {
            JOptionPane.showMessageDialog(null, "The specified " + issue + " is not a " +
                    "valid number", "Product Inventory", JOptionPane.ERROR_MESSAGE);
            issue = "";
        } else {
            sku = addView.getSkuTextField().getText();
            name = addView.getNameTextField().getText();
            quantity = Integer.parseInt(addView.getQuantityTextField().getText());
            retail = Double.parseDouble(addView.getRetailPriceTextField().getText());
            wholesale = Double.parseDouble(addView.getWholesalePriceTextField().getText());
            Optional<Product> searchSKU = inventoryModel.searchBySku(String.valueOf(sku));
            if (!searchSKU.isEmpty()) {
                JOptionPane.showMessageDialog(null, "This product could not be added to " +
                                "inventory!\n A product with the specified SKU already exists!", "Product Inventory",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Product newProduct = new Product(String.valueOf(sku), name, (double) wholesale, (double) retail,
                        (int) quantity);
                inventoryModel.add(newProduct);
                JOptionPane.showMessageDialog(null, "This product has been added to the inventory",
                        "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                addView.getSkuTextField().requestFocus();
                //System.out.println(newProduct.toString());
            } //getAddButtonSemantics

        }
    }
    /**
     * Gets the semantics of an add view's clear button.
     */
    private void getClearButtonSemantics() {
        addView.getSkuTextField().setText("");
        addView.getNameTextField().setText("");
        addView.getQuantityTextField().setText("");
        addView.getRetailPriceTextField().setText("");
        addView.getWholesalePriceTextField().setText("");
        addView.getSkuTextField().requestFocus();
    } //getClearButtonSemantics

    /**
     * Gets the hash code of this add controller.
     *
     * @return the hash code of this add controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.addView == null ? 0 : this.addView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this add controller is equal to the specified object. {@code true} is returned if and
     * only if the specified object is an instance of {@code AddController}, and its field values are equal to this
     * add controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this add controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof AddController)
                && (this.inventoryModel == null ? ((AddController) anObject).inventoryModel == null : this.inventoryModel.equals(((AddController) anObject).inventoryModel))
                && (this.addView == null ? ((AddController) anObject).addView == null : this.addView.equals(((AddController) anObject).addView));
    } //equals

    /**
     * Gets a {@code String} representation of this add controller.
     *
     * @return a {@code String} representation of this add controller
     */
    @Override
    public String toString() {
        return String.format("AddController[%s, %s]", this.inventoryModel, this.addView);
    } //toString
}