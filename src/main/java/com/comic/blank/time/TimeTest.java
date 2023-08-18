package com.comic.blank.time;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ..w-chen..
 */
public class TimeTest {

    public static void main(String[] args) {
        // 2021-10-18     2099-12-31
        Long startTime1 = 1634486400L;
        Long endTime1 = 4102329600L;

        // 2021-11-01    2021-11-15
        Long startTime2 = 1635696000L;
        Long endTime2 = 1636991999L;

        // 2021-11-16    2021-11-17
        Long startTime3 = 1636992000L;
        Long endTime3 = 1637164799L;


        // 2021-11-18 00:00:00
        Long startTime4 = 1637164800L;
        // 2022-12-31 00:00:00
        Long endTime4 = 1672416000L;

        // 2022-12-31 00:00:01
        Long startTime5 = 1672416001L;
        // 2023-12-31 00:00:00
        Long endTime5 = 1703952000L;

        boolean isOverlapped = overlapped(buildSlot(ofEpochMilli(startTime4), ofEpochMilli(endTime4)), buildSlot(ofEpochMilli(startTime5), ofEpochMilli(endTime5)));
        System.out.println(isOverlapped);

        String a = "Sat Dec 31 00:00:01 CST 2022";
        System.out.println(formatDate(a));


//        System.out.println(compute(buildSlot(ofEpochMilli(startTime1), ofEpochMilli(endTime1), "物料A 20元"), buildSlot(ofEpochMilli(startTime2), ofEpochMilli(endTime2), "物料A 30元")));
//        System.out.println(compute(buildSlot(ofEpochMilli(startTime2), ofEpochMilli(endTime2), "物料A 20元"), buildSlot(ofEpochMilli(startTime3), ofEpochMilli(endTime3), "物料A 30元")));
//        System.out.println(compute(buildSlot(ofEpochMilli(startTime1), ofEpochMilli(endTime1), "物料A 20元"), buildSlot(ofEpochMilli(startTime3), ofEpochMilli(endTime3), "物料A 30元")));
        TimeSlot slot1 = new TimeSlot(ofEpochMilli(startTime1), ofEpochMilli(endTime1), "物料A 100元");
        TimeSlot slot2 = new TimeSlot(ofEpochMilli(startTime2), ofEpochMilli(endTime2), "物料A 90元");
        TimeSlot slot3 = new TimeSlot(ofEpochMilli(startTime3), ofEpochMilli(endTime3), "物料A 90元");
        List<TimeSlot> slots = Lists.newLinkedList();
        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);
        System.out.println(computeList(slots));

//        System.out.println(overlappedOfInteger(Lists.newArrayList(new IntegerSlot(1, 10, "物料A"), new IntegerSlot(11, 16, "物料A"), new IntegerSlot(12, 17, "物料A"))));
//
//        System.out.println(overlapped(slots));
    }

    public static Boolean overlappedOfInteger(List<IntegerSlot> slots) {
        if (CollectionUtils.isEmpty(slots)) {
            return false;
        }
        if (slots.size() == 1) {
            return false;
        }
        // 互斥区间
        List<IntegerSlot> mutexSlots = Lists.newLinkedList();
        for (IntegerSlot slot : slots) {
            if (overlapped(mutexSlots, slot)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean overlapped(List<IntegerSlot> mutexSlots, IntegerSlot slot) {
        if (CollectionUtils.isEmpty(mutexSlots)) {
            mutexSlots.add(slot);
            return false;
        }
        // 是否重叠
        boolean isOverlapped = false;
        for (IntegerSlot integerSlot : mutexSlots) {
            // 存在重叠的区间就返回
            if (overlapped(integerSlot, slot)) {
                isOverlapped = true;
                break;
            }
        }
        if (!isOverlapped) {
            mutexSlots.add(slot);
        }
        return isOverlapped;
    }

    public static Boolean overlapped(IntegerSlot slot1, IntegerSlot slot2) {
        return Math.max(slot1.getStart(), slot2.getStart()) <= Math.min(slot1.getEnd(), slot2.getEnd());
    }

    public static List<TimeSlot> computeList(List<TimeSlot> slots) {
        if (CollectionUtils.isEmpty(slots)) {
            return Lists.newArrayList();
        }
        if (slots.size() == 1) {
            return slots;
        }
        List<TimeSlot> splitSlots = Lists.newLinkedList();
        for (TimeSlot slot : slots) {
            splitSlots = compute(splitSlots, slot);
        }
        // 排序
        splitSlots.sort(Comparator.comparing(TimeSlot::getStartTime));
        return splitSlots;
    }

    public static List<TimeSlot> compute(List<TimeSlot> slots, TimeSlot slot) {
        // slot优先级高于slots中所有
        if (CollectionUtils.isEmpty(slots)) {
            return Lists.newArrayList(slot);
        }
        List<TimeSlot> splitSlot = Lists.newLinkedList();
        for (TimeSlot timeSlot : slots) {
            splitSlot.addAll(compute(timeSlot, slot));
        }
        // 去掉重复区间
        return splitSlot.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(x -> x.getMaterialCode() + ";" + x.getStartTime().toEpochSecond(ZoneOffset.of("+8")) + ";" + x.getEndTime().toEpochSecond(ZoneOffset.of("+8"))))), ArrayList::new));
    }

    public static List<TimeSlot> compute(TimeSlot slot1, TimeSlot slot2) {
        // 如果存在重叠区间（slot2的优先级高）
        if (overlapped(slot1, slot2)) {
            if (slot1.getStartTime().isBefore(slot2.getStartTime())) {
                if (slot1.getEndTime().isAfter(slot2.getEndTime())) {
                    List<TimeSlot> timeSlots = Lists.newLinkedList();
                    timeSlots.add(new TimeSlot(slot1.getStartTime(), minusSecond(slot2.getStartTime()), slot1.getMaterialCode()));
                    timeSlots.add(slot2);
                    timeSlots.add(new TimeSlot(plusSecond(slot2.getEndTime()), slot1.getEndTime(), slot1.getMaterialCode()));
                    return timeSlots;
                } else {
                    List<TimeSlot> timeSlots = Lists.newLinkedList();
                    timeSlots.add(new TimeSlot(slot1.getStartTime(), minusSecond(slot2.getStartTime()), slot1.getMaterialCode()));
                    timeSlots.add(slot2);
                    return timeSlots;
                }
            } else if (slot1.getStartTime().equals(slot2.getStartTime())) {
                if (slot1.getEndTime().isAfter(slot2.getEndTime())) {
                    List<TimeSlot> timeSlots = Lists.newLinkedList();
                    timeSlots.add(slot2);
                    timeSlots.add(new TimeSlot(plusSecond(slot2.getEndTime()), slot1.getEndTime(), slot1.getMaterialCode()));
                    return timeSlots;
                } else {
                    List<TimeSlot> timeSlots = Lists.newLinkedList();
                    timeSlots.add(slot2);
                    return timeSlots;
                }
            } else {
                if (slot1.getEndTime().isAfter(slot2.getEndTime())) {
                    List<TimeSlot> timeSlots = Lists.newLinkedList();
                    timeSlots.add(slot2);
                    timeSlots.add(new TimeSlot(plusSecond(slot2.getEndTime()), slot1.getEndTime(), slot1.getMaterialCode()));
                    return timeSlots;
                } else {
                    List<TimeSlot> timeSlots = Lists.newLinkedList();
                    timeSlots.add(slot2);
                    return timeSlots;
                }
            }
        }
        return Lists.newArrayList(slot1, slot2);
    }

    private static LocalDateTime minusSecond(LocalDateTime localDateTime) {
        return localDateTime.minusSeconds(1L);
    }

    private static LocalDateTime plusSecond(LocalDateTime localDateTime) {
        return localDateTime.plusSeconds(1L);
    }

    public static LocalDateTime ofEpochMilli(long epochMilli) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli * 1000L), ZoneOffset.of("+8"));
    }

    /**
     * 判断时间区间集合中任意一个时间区间是否重叠
     *
     * @param slots 时间区间集合
     * @return true/false
     */
    public static Boolean overlapped(List<TimeSlot> slots) {
        if (CollectionUtils.isEmpty(slots)) {
            return false;
        }
        if (slots.size() == 1) {
            return false;
        }
        // 互斥时间区间
        List<TimeSlot> mutexSlots = Lists.newLinkedList();
        for (TimeSlot slot : slots) {
            if (overlapped(mutexSlots, slot)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断时间区间与时间区间集合任一一个时间段是否重叠
     *
     * @param mutexSlots 互斥的时间区间集合
     * @param slot       时间区间
     * @return boolean
     */
    public static Boolean overlapped(List<TimeSlot> mutexSlots, TimeSlot slot) {
        if (CollectionUtils.isEmpty(mutexSlots)) {
            mutexSlots.add(slot);
            return false;
        }
        // 是否重叠
        boolean isOverlapped = false;
        for (TimeSlot timeSlot : mutexSlots) {
            // 存在重叠的时间区间就返回
            if (overlapped(timeSlot, slot)) {
                isOverlapped = true;
            }
        }
        if (!isOverlapped) {
            mutexSlots.add(slot);
        }
        return isOverlapped;
    }

    private static Boolean overlapped(TimeSlot slot1, TimeSlot slot2) {
        TimeSlot previous = slot1.getStartTime().isBefore(slot2.getStartTime()) ? slot1 : slot2;
        TimeSlot next = slot2.getStartTime().isAfter(slot1.getStartTime()) ? slot2 : slot1;
        return !(lt(previous, next) || gt(previous, next));
    }

    /**
     * 构造时间段
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static TimeSlot buildSlot(LocalDateTime startTime, LocalDateTime endTime) {
        return new TimeSlot(startTime, endTime);
    }

    public static TimeSlot buildSlot(LocalDateTime startTime, LocalDateTime endTime, String materialCode) {
        return new TimeSlot(startTime, endTime, materialCode);
    }

    /**
     * less equal
     * 小于等于
     *
     * @param prev
     * @param next
     * @return
     */
    private static boolean le(TimeSlot prev, TimeSlot next) {
        return lt(prev, next) || next.getEndTime().isEqual(prev.getStartTime());
    }

    /**
     * greater equal
     * 大于等于
     *
     * @param prev
     * @param next
     * @return
     */
    private static boolean ge(TimeSlot prev, TimeSlot next) {
        return gt(prev, next) || prev.getEndTime().isEqual(next.getStartTime());
    }

    /**
     * greater than
     * 大于
     *
     * @param prev
     * @param next
     * @return
     */
    private static boolean gt(TimeSlot prev, TimeSlot next) {
        return prev.getEndTime().isBefore(next.getStartTime());
    }

    /**
     * less than
     * 小于
     *
     * @param prev
     * @param next
     * @return
     */
    private static boolean lt(TimeSlot prev, TimeSlot next) {
        return next.getEndTime().isBefore(prev.getStartTime());
    }

    public static long formatDate(String date) {
        return formatDate(date, DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US));
    }

    public static long formatDate(String date, DateTimeFormatter formatter) {
        LocalDateTime localDateTime = LocalDateTime.parse(StringUtils.trim(date), formatter);
        return localDateTime.toEpochSecond(ZoneOffset.ofHours(8));
    }

}
