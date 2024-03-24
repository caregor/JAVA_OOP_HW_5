package representers;

import models.TablesRepository;
import views.BookingView;

import java.util.Date;

public class BookingPresenter implements ViewObserver{

    private Model model;
    private View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTablesView(){
        view.showTables(model.loadTables());
    }

    private void updateReservationTableView(int resrvationNo){
        view.showReservationTableResult(resrvationNo);
    }

    private void updateChangesReservationTableView(int newResrvationNo){
        view.showChangesReservationTableResult(newResrvationNo);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int resrvationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(resrvationNo);
        }
        catch (Exception e) {
            updateReservationTableView(-1);
        }
    }

    @Override
    public void onChangeReservationTable(int oldNo, Date date, int newNo, String name) {
        try {
            int nextReservationNo = model.changeReservationTable(oldNo, date, newNo, name);
            updateChangesReservationTableView(nextReservationNo);

        }
        catch (Exception e) {
            updateChangesReservationTableView(-1);
        }
    }
}
