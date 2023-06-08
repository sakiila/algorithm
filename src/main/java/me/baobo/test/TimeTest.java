package me.baobo.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TimeTest {
    
    public static void main(String[] args) {
        LocalDate workingHourStartDate = LocalDate.of(2023, 3, 5);
        int temp = workingHourStartDate.getDayOfWeek().getValue() % 7;
        
        LocalDate currentLocalDate = LocalDate.of(2023, 6, 10);
        // LocalDate currentLocalDate = LocalDate.of(2023, 3, 4);
        
        // 计算 startDate 所在星期的星期日，也就是绝对开始时间
        LocalDate absoluteStartDate = workingHourStartDate.minusDays(temp);
        System.out.println("absoluteStartDate = " + absoluteStartDate);
        
        // 计算 date 距离 absoluteStartDate 的天数差
        Period between = Period.between(absoluteStartDate, currentLocalDate);
        System.out.println("between.getDays() = " + between.getDays());
        
        // 计算 date 是距离 absoluteStartDate 的星期差
        int weeksBetween = Math.floorDiv(between.getDays(), 7);
        System.out.println("weeksBetween = " + weeksBetween);
        
        // 计算循环中第几周
        int weekNumber = Math.floorMod(weeksBetween, 2);
        System.out.println("weekNumber = " + weekNumber);
        System.out.println();
    
        long timeBetween = ChronoUnit.DAYS.between(absoluteStartDate, currentLocalDate);
        System.out.println("timeBetween = " + timeBetween);
        long weeksBetweenNew = Math.floorDiv(timeBetween, (byte) 7);
        System.out.println("weeksBetweenNew = " + weeksBetweenNew);
        int weekNumberNew = Math.toIntExact(Math.floorMod(weeksBetweenNew, 2));
        System.out.println("weekNumberNew = " + weekNumberNew);
        
        
    }
    
}
