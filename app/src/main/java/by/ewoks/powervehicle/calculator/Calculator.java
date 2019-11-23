package by.ewoks.powervehicle.calculator;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import by.ewoks.powervehicle.calculator.model.StatRefuel;
import by.ewoks.powervehicle.calculator.model.VehicleStatData;
import by.ewoks.powervehicle.common.entities.Refuel;
import by.ewoks.powervehicle.common.entities.Service;

public abstract class Calculator {

    @Nullable
    public static List<StatRefuel> makeStatRefuelList(List<Refuel> refuelList) {
        if (refuelList == null) return null;
        if (refuelList.size() == 0) return null;
        List<StatRefuel> statRefuelList = new ArrayList<>();
        statRefuelList.add(new StatRefuel(
                refuelList.get(0),
                null,
                refuelList.get(0).getFuelPrice() * refuelList.get(0).getFuelVolume(),
                null));
        if (refuelList.size() > 1)
            for (int i = 1; i < refuelList.size(); i++) {
                Refuel currentRefuel = refuelList.get(i);
                Refuel previousRefuel = refuelList.get(i - 1);
                int incrementMileage = currentRefuel.getMileage() - previousRefuel.getMileage();
                double incrementMoney = currentRefuel.getFuelPrice() * currentRefuel.getFuelVolume();
                if (currentRefuel.getFullTankFlag() && previousRefuel.getFullTankFlag()) {
                    double currentConsumption = currentRefuel.getFuelVolume() * 100.0 / incrementMileage;
                    statRefuelList.add(new StatRefuel(currentRefuel, incrementMileage, incrementMoney, currentConsumption));
                } else {
                    statRefuelList.add(new StatRefuel(currentRefuel, incrementMileage, incrementMoney, null));
                }
            }
        return statRefuelList;
    }

    @Nullable
    public static VehicleStatData getVehicleStatData(List<Refuel> vehicleRefuelList, List<Service> vehicleServiceList) {
        if (vehicleRefuelList.isEmpty() && vehicleServiceList.isEmpty()) return null;
        int totalMileage;
        double totalFuelBurnt = 0;
        double totalFuelExpense = 0;
        double averageFuelConsumption;
        double averageMileageOnOneRefuel;
        double drivingCostFuelOnly;
        double drivingCostServiceAndFuel;
        double totalServiceExpense = 0;
        if (!vehicleRefuelList.isEmpty()) {
            totalFuelBurnt = 0;
            totalFuelExpense = 0;
            for (Service vehicleService : vehicleServiceList)
                totalServiceExpense += vehicleService.getServiceCost();

        }
        totalMileage = vehicleRefuelList.get(vehicleRefuelList.size() - 1).getMileage() - vehicleRefuelList.get(0).getMileage();
        for (Refuel refuel : vehicleRefuelList) {
            totalFuelBurnt += refuel.getFuelVolume();
            totalFuelExpense += refuel.getFuelPrice() * refuel.getFuelVolume();
        }
        if (totalMileage == 0) {
            averageFuelConsumption = 0;
            averageMileageOnOneRefuel = 0;
            drivingCostFuelOnly = 0;
            drivingCostServiceAndFuel = 0;
            return new VehicleStatData(
                    totalMileage,
                    totalFuelExpense,
                    totalServiceExpense,
                    totalFuelBurnt,
                    averageFuelConsumption,
                    averageMileageOnOneRefuel,
                    drivingCostFuelOnly,
                    drivingCostServiceAndFuel);
        } else {
            averageFuelConsumption = (totalFuelBurnt - vehicleRefuelList.get(0).getFuelVolume()) / totalMileage;
            averageMileageOnOneRefuel = totalMileage / vehicleRefuelList.size() - 1;
            drivingCostFuelOnly = totalFuelExpense * 100.0 / totalMileage;
            drivingCostServiceAndFuel = (totalFuelExpense + totalServiceExpense) * 100.0 / totalMileage;
            return new VehicleStatData(
                    totalMileage,
                    totalFuelExpense,
                    totalServiceExpense,
                    totalFuelBurnt,
                    averageFuelConsumption,
                    averageMileageOnOneRefuel,
                    drivingCostFuelOnly,
                    drivingCostServiceAndFuel);
        }
    }
}
