package by.ewoks.powervehicle.statistics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;
import java.util.List;

import by.ewoks.powervehicle.R;
import by.ewoks.powervehicle.calculator.Calculator;
import by.ewoks.powervehicle.calculator.model.VehicleStatData;
import by.ewoks.powervehicle.common.AppDbManager;
import by.ewoks.powervehicle.common.entities.Refuel;
import by.ewoks.powervehicle.common.entities.Service;
import by.ewoks.powervehicle.common.entities.Vehicle;
import by.ewoks.powervehicle.helpers.SharedPreferencesHelper;

public class StatisticsFragment extends Fragment {
    private List<Refuel> refuelList;
    private List<Service> serviceList;
    private long vehicleId;
    private TextView totalMileage;
    private TextView totalFuelExpense;
    private TextView totalServiceExpense;
    private TextView totalFuelBurnt;
    private TextView averageFuelConsumption;
    private TextView averageMileageOnOneRefuel;
    private TextView drivingCostFuelOnly;
    private TextView drivingCostServiceAndFuel;
    private DecimalFormat df = new DecimalFormat("#.##");



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View hierarchy = inflater.inflate(R.layout.fragment_show_statistics, container, false);
        vehicleId = SharedPreferencesHelper.getLastID(getContext());
        refuelList = AppDbManager.INSTANCE.getDb().refuelDao().getAllRefuelsList();
        serviceList = AppDbManager.INSTANCE.getDb().serviceDao().getAllServicesList();
        VehicleStatData statData = Calculator.getVehicleStatData(refuelList, serviceList);

        totalMileage = hierarchy.findViewById(R.id.vTotalMileageText);
        totalMileage.setText(statData.getTotalMileage());
        totalFuelExpense = hierarchy.findViewById(R.id.vTotalFuelExpenseText);
        totalFuelExpense.setText(df.format(statData.getTotalFuelExpense()));
        totalServiceExpense = hierarchy.findViewById(R.id.vTotalServiceExpenseText);
        totalServiceExpense.setText(df.format(statData.getTotalServiceExpense()));
        totalFuelBurnt = hierarchy.findViewById(R.id.vTotalFuelBurntText);
        totalFuelBurnt.setText(df.format(statData.getTotalFuelBurnt()));
        averageFuelConsumption = hierarchy.findViewById(R.id.vFuelConsumptionText);
        averageFuelConsumption.setText(df.format(statData.getAverageFuelConsumption()));
        averageMileageOnOneRefuel = hierarchy.findViewById(R.id.vMileageOnOneRefuelText);
        averageMileageOnOneRefuel.setText(df.format(statData.getAverageMileageOnOneRefuel()));
        drivingCostFuelOnly = hierarchy.findViewById(R.id.vDrivingCostFuelOnlyText);
        drivingCostFuelOnly.setText(df.format(statData.getDrivingCostFuelOnly()));
        drivingCostServiceAndFuel = hierarchy.findViewById(R.id.vDrivingCostServiceAndFuelText);
        drivingCostServiceAndFuel.setText(df.format(statData.getDrivingCostServiceAndFuel()));



        return hierarchy;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }





    }
}
