import javax.swing.*;
import java.util.Optional;

/**
 * An update controller of a product inventory application.
 *
 * <p>CS18000 -- Summer 2019 -- Complex GUIs -- Homework</p>
 */
public final class UpdateController {
    /**
     * The inventory model of this update controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The update view of this update controller.
     */
    private UpdateView updateView;

    /**
     * Constructs a newly allocated {@code UpdateController} object with the specified inventory model and update view.
     *
     * @param inventoryModel the inventory model of this update controller
     * @param updateView the update view of this update controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code updateView} argument is
     * {@code null}
     */
    public UpdateController(InventoryModel inventoryModel, UpdateView updateView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (updateView == null) {
            throw new IllegalArgumentException("updateView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.updateView = updateView;

            this.updateView.getUpdateButton().addActionListener(e -> this.getUpdateButtonSemantics());

            this.updateView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //UpdateController

    /**
     * Gets the semantics of an update view's update button.
     */
    private void getUpdateButtonSemantics() {
       String sku = updateView.getSkuTextField().getText();
       Optional<Product> skuSearch = inventoryModel.searchBySku(sku);
       if(skuSearch.isEmpty()){
           JOptionPane.showMessageDialog(null, "A product with the specified SKU does not " +
                   "exist in the inventory!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
       }
       else{
           if(updateView.getFieldComboBox().getSelectedItem() == null){
               JOptionPane.showMessageDialog(null,"Please select a field to be updated",
                       "Product Inventory", JOptionPane.ERROR_MESSAGE);
           } else if(updateView.getNewFieldValueTextField().getText() == null){
               JOptionPane.showMessageDialog(null, "Please enter an updated value", "Product Inventory", JOptionPane.ERROR_MESSAGE);
           }
           else {
               String selected = updateView.getFieldComboBox().getSelectedItem().toString();
               String issue = "";
               String reason = "";
               if(selected.equals("SKU")){
                   String SKU = updateView.getNewFieldValueTextField().getText();
                   Optional<Product> Sku = inventoryModel.searchBySku(SKU);
                   if(!Sku.isEmpty()){
                       issue = "SKU";
                       reason = "already exists";
                       JOptionPane.showMessageDialog(null, "This product’s specified " + issue
                       + " could not be updated!\nThe specified " + issue + " " + reason + "!",
                               "Product Inventory", JOptionPane.ERROR_MESSAGE);
                   } else{
                       Optional<Product> changedProduct = inventoryModel.searchBySku(updateView.getSkuTextField().getText());
                       changedProduct.get().setSku(SKU);
                       JOptionPane.showMessageDialog(null, "This product's SKU has been " +
                               "updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                       updateView.getSkuTextField().requestFocus();
                   }
               }
               else if(selected.equals("Name")){
                   String newName = updateView.getNewFieldValueTextField().getText();
                   Optional<Product> product = inventoryModel.searchBySku(updateView.getSkuTextField().getText());
                   product.get().setName(newName);
                   JOptionPane.showMessageDialog(null, "This product's name has been " +
                           "updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
               } else if(selected.equals("Wholesale price")){
                   try{
                       double newWholesale = Double.parseDouble(updateView.getNewFieldValueTextField().getText());
                       Optional<Product> product = inventoryModel.searchBySku(updateView.getSkuTextField().getText());
                       product.get().setWholesalePrice(newWholesale);
                       JOptionPane.showMessageDialog(null, "This product's wholesale price has been " +
                               "updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                   } catch (NumberFormatException e) {
                       JOptionPane.showMessageDialog(null, "This product's wholesale price " +
                               "could not be updated!\nThe specified wholesale price is not a valid number!", "Product Inventory",
                               JOptionPane.ERROR_MESSAGE);
                   }
               } else if(selected.equals("Retail price")){
                   try{
                       double newRetail = Double.parseDouble(updateView.getNewFieldValueTextField().getText());
                       Optional<Product> product = inventoryModel.searchBySku(updateView.getSkuTextField().getText());
                       product.get().setRetailPrice(newRetail);
                   } catch (NumberFormatException e) {
                       JOptionPane.showMessageDialog(null, "This product's retail price " +
                                       "could not be updated!\nThe specified retail price is not a valid number!", "Product Inventory",
                               JOptionPane.ERROR_MESSAGE);
                   }
               } else if(selected.equals("Quantity")){
                   try{
                       int newQuantity = Integer.parseInt(updateView.getNewFieldValueTextField().getText());
                       Optional<Product> product = inventoryModel.searchBySku(updateView.getSkuTextField().getText());
                       product.get().setQuantity(newQuantity);
                   } catch (IllegalArgumentException e) {
                       JOptionPane.showMessageDialog(null, "This product's quantity " +
                                       "could not be updated!\nThe specified quantity is not a valid number!", "Product Inventory",
                               JOptionPane.ERROR_MESSAGE);
                   }
               }
           }
       }
    } //getUpdateButtonSemantics

    /**
     * Gets the semantics of an update view's clear button.
     */
    private void getClearButtonSemantics() {
        updateView.getSkuTextField().setText("");
        updateView.getNewFieldValueTextField().setText("");
        updateView.getFieldComboBox().setSelectedItem(null);
        updateView.getSkuTextField().requestFocus();
    } //getClearButtonSemantics

    /**
     * Gets the hash code of this update controller.
     *
     * @return the hash code of this update controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.updateView == null ? 0 : this.updateView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this update controller is equal to the specified object. {@code true} is returned if
     * and only if the specified object is an instance of {@code UpdateController}, and its field values are equal to
     * this update controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this update controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof UpdateController)
                && (this.inventoryModel == null ? ((UpdateController) anObject).inventoryModel ==  null : this.inventoryModel.equals(((UpdateController) anObject).inventoryModel))
                && (this.updateView == null ? ((UpdateController) anObject).updateView ==  null : this.updateView.equals(((UpdateController) anObject).updateView));
    } //equals

    /**
     * Gets a {@code String} representation of this update controller.
     *
     * @return a {@code String} representation of this update controller
     */
    @Override
    public String toString() {
        return String.format("UpdateController[%s, %s]", this.inventoryModel, this.updateView);
    } //toString
}