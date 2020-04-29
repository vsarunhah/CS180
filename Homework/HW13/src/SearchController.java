import javax.swing.*;

/**
 * A search controller of a product inventory application.
 *
 * <p>CS18000 -- Summer 2019 -- Complex GUIs -- Homework</p>
 */
public final class SearchController {
    /**
     * The inventory model of this search controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The search view of this search controller.
     */
    private SearchView searchView;

    /**
     * Constructs a newly allocated {@code SearchController} object with the specified inventory model and search view.
     *
     * @param inventoryModel the inventory model of this search controller
     * @param searchView the search view of this search controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code searchView} argument is
     * {@code null}
     */
    public SearchController(InventoryModel inventoryModel, SearchView searchView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (searchView == null) {
            throw new IllegalArgumentException("searchView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.searchView = searchView;

            this.searchView.getSearchButton().addActionListener(e -> this.getSearchButtonSemantics());

            this.searchView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //SearchController

    /**
     * Gets the semantics of a search view's search button.
     */
    private void getSearchButtonSemantics() {
        if(searchView.getFieldComboBox().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Please select a field!", "Product Inventory",
                    JOptionPane.ERROR_MESSAGE);
            searchView.getFieldComboBox().requestFocus();
        } else{
            if(!searchView.getFieldComboBox().getSelectedItem().equals("Name"))
        }
    } //getSearchButtonSemantics

    /**
     * Gets the semantics of a search view's clear button.
     */
    private void getClearButtonSemantics() {
        searchView.getFieldComboBox().setSelectedItem(null);
        searchView.getResultsTextArea().setText("");
        searchView.getSearchValueTextField().setText("");
        searchView.getSearchValueTextField().requestFocus();
    } //getClearButtonSemantics

    /**
     * Gets the hash code of this search controller.
     *
     * @return the hash code of this search controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.searchView == null ? 0 : this.searchView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this search controller is equal to the specified object. {@code true} is returned if
     * and only if the specified object is an instance of {@code SearchController}, and its field values are equal to
     * this search controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this search controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof SearchController)
                && (this.inventoryModel == null ? ((SearchController) anObject).inventoryModel ==  null : this.inventoryModel.equals(((SearchController) anObject).inventoryModel))
                && (this.searchView == null ? ((SearchController) anObject).searchView ==  null : this.searchView.equals(((SearchController) anObject).searchView));
    } //equals

    /**
     * Gets a {@code String} representation of this search controller.
     *
     * @return a {@code String} representation of this search controller
     */
    @Override
    public String toString() {
        return String.format("SearchController[%s, %s]", this.inventoryModel, this.searchView);
    } //toString
}