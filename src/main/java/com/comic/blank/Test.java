package com.comic.blank;

import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.comic.blank.enums.TestEnum;
import com.comic.blank.utils.PwdCheckUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author ..w-chen..
 */
public class Test {

    private final static Map<String, String> constantMap = Maps.newHashMap();

    private final static String constantStr = "a";

    private static final String REGEX_MOBILEPHONE = "^0?1[23456789]\\d{9}$";

    private static final Pattern MATERIAL_CDOE_COMPILE = Pattern.compile("[0-9]-[0-9]{9}$");

    private static Pattern PATTERN_MOBILEPHONE;

    static {
        constantMap.put("a", "1");
        constantMap.put("b", "2");
        PATTERN_MOBILEPHONE = Pattern.compile(REGEX_MOBILEPHONE);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        User user1 = new User(true, 100434L, "王宸", "000000");
//        User user2 = new User(true, 100434L, "王宸", "111111");
//        User user3 = new User(true, 100435L, "尹昌", "111111");
//        List<User> users = Lists.newArrayList(user1, user2, user3);
//        System.out.println(users.stream().filter(distinctByKey(User::getUnionId)).collect(Collectors.toList()));
//        System.out.println(users.stream().min(Comparator.comparing(User::getUnionId)).orElse(null));
//        System.out.println(users.stream().peek(x -> {
//            if (x.getUnionId().equals(100434L)) {
//                throw new IllegalArgumentException("错误");
//            }
//        }).collect(Collectors.toMap(User::getUnionId,v->v,(v1,v2)->v1)));

        System.out.println((int) (Duration.ofDays(30).getSeconds()));

        System.out.println(TestEnum.getCodeByName("帅"));

        String materialCode = "223000001";
        System.out.println(StringUtils.startsWith(materialCode, "2"));

        String a = "[\"wangchen@yeelight.com\",\"yinchang@yeelight.com\"]";
        System.out.println(JSON.parseObject(a, new TypeReference<Set<String>>() {
        }));


        Pair pair = Pair.of(null, "a");
        System.out.println(pair);
        System.out.println(pair.getLeft() == null);

        Map<String, List<String>> map = Maps.newHashMap();
        List<String> list = Lists.newArrayList("a", "b");
        map.put("list", list);
        map.get("list").add("c");
        System.out.println(map);

        String materialCode3 = "1-001";
        String materialCode1 = "0-100001-001";
        String materialCode2 = "0-200001";
        String mateiralCode4 = "0-0000001";
        System.out.println(StringUtils.startsWithAny(materialCode3, "1", "0-1", "0-2"));
        System.out.println(StringUtils.startsWithAny(materialCode1, "1", "0-1", "0-2"));
        System.out.println(StringUtils.startsWithAny(materialCode2, "1", "0-1", "0-2"));
        System.out.println(StringUtils.startsWithAny(mateiralCode4, "1", "0-1", "0-2"));
        System.out.println(StringUtils.substring(materialCode2, 0, 3));

        LocalDateTime endTime = LocalDateTime.of(2021, Month.JUNE, 27, 18, 0, 0);
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(endTime, now);
        System.out.println(duration.toMillis() >= 0L);

        String contain = "调用管易:gy.erp.item.add 接口失败，原因：商品已存在!";
        System.out.println(StringUtils.contains(contain, "商品已存在"));

        System.out.println(StringUtils.replace("A+B+C", "+", "-"));

        List<String> aList = Lists.newArrayList("光学图", "宣传图", "参考图", "三视图");
        List<String> bList = Lists.newArrayList("光学图", "宣传图", "参考图", "三视图", "三视图", "三视图", "参考图");
        System.out.println(CollectionUtils.containsAll(bList, aList));

        BigDecimal bigDecimal1 = new BigDecimal(100L);
        BigDecimal bigDecimal2 = new BigDecimal(3L);
        System.out.println(bigDecimal1.divide(bigDecimal2, 0, RoundingMode.HALF_UP));

        System.out.println(StringUtils.contains("配件，不需分配69码", "待分配"));

        System.out.println(isValidDate("2019/1/1"));
        System.out.println(isValidDates("2019/1/1-2020/2/2"));

        System.out.println(!StringUtils.contains(null, "不支持"));
        System.out.println(Objects.equals("", "2"));

        List<String> priceTests = Lists.newArrayList("2002", "2001");
        List<String> productTests = Lists.newArrayList("2002", "2003");
        System.out.println(CollectionUtils.containsAny(priceTests, productTests));

        System.out.println(Lists.transform(priceTests, Long::valueOf));

        Map<String, String> amap = Maps.newHashMap();
        amap.put("a", "b");
        System.out.println(amap.getOrDefault(null, null));

        List<User> testList = Lists.newArrayList();
        System.out.println(Maps.uniqueIndex(testList, User::getUnionId));

        // long时间戳转String日期
        System.out.println(timeOfLongToStr(1628056845000L));
        // 创建Bigdecimal
        System.out.println(NumberUtils.createBigDecimal("6.84404024767802"));

        // 测试空list的groupingBy分组
        System.out.println(Lists.<User>newArrayList().stream().collect(Collectors.groupingBy(User::getUnionId)));

        // 测试空list转map
        System.out.println(Lists.<User>newArrayList().stream().collect(Collectors.toMap(User::getUnionId, Function.identity())));

        // 获取现在时间（毫秒）
        System.out.println(Instant.now().toEpochMilli());

        // 倒序排序
        List<Boolean> bools = Lists.newArrayList(true, true, false);
        System.out.println(bools.stream().sorted(Comparator.comparing(x -> x, Comparator.reverseOrder())).collect(Collectors.toList()));

        // 获取今天属于当月的哪天
        System.out.println(LocalDate.now().getDayOfMonth());

        // key value倒置
        Map<String, String> testMap = Maps.newHashMap();
        testMap.put("a", "1");
        testMap.put("b", "2");
        System.out.println(MapUtils.invertMap(testMap));

        // list引用变更
//        User testUser1 = new User(true, 10011L, "王宸", "000000");
//        User testUser2 = new User(true, 10012L, "尹昌", "11111");
//        List<User> userList = Lists.newArrayList(testUser1, testUser2);
//        System.out.println(userList);
//        userList.forEach(user -> user.setExe(false));
//        System.out.println(userList);

        // 获取json配置里的key值
        String json = "{'key':'value'}";
        System.out.println(getJsonForCode(json, "key"));

        Map<String, String> map1 = Maps.newHashMap();
        map1.put("a", "a");
        System.out.println(map1);
        map1.putAll(Maps.newConcurrentMap());
        System.out.println(map1);

        String aAndB = "1001-1002";
        System.out.println(StringUtils.split(aAndB, "-")[0]);
        System.out.println(StringUtils.split(aAndB, "-")[1]);

        // 测试StringUtils.startsWith
        String str = "SPT000001";
        System.out.println(StringUtils.startsWith(str, "PT"));

        // 测试final map的remove和put
        System.out.println(constantMap);
        constantMap.remove("a");
        System.out.println(constantMap);
        constantMap.put("c", "3");
        System.out.println(constantMap);

        // 测试字符串的比较
        String a1 = "str";
        String b1 = "ing";
        String c1 = a1 + b1;
        String d1 = "str" + "ing";
        String e1 = "string";
        System.out.println(c1 == d1);
        System.out.println(c1 == e1);
        System.out.println(d1 == e1);

        // 测试获取现在时间和上个月时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("现在时间:" + localDateTime);
        localDateTime = localDateTime.minusMonths(1L);
        System.out.println("上个月时间:" + localDateTime);

        // 测试Byte的比较
        Byte byte1 = 0;
        System.out.println(Objects.equals(byte1, (byte) 0));

        // 测试ListUtils.union
        List<String> list1 = Lists.newArrayList("a");
        System.out.println(ListUtils.union(list1, Lists.newArrayList()));

        // 测试stringUtils的substring等方法
        String spec = "21433:65038021:尺寸:300mmx300mm";
//        System.out.println(StringUtils.split(spec, ":")[0] + ":" + StringUtils.split(spec, ":")[4]);
        System.out.println(StringUtils.substringAfterLast(spec, ":"));
        System.out.println(StringUtils.substringBeforeLast(spec, ":"));
        System.out.println(StringUtils.substringBefore(spec, ":"));
        System.out.println(StringUtils.substringAfter(spec, ":"));

        // 测试正则表达式
        String aaa = "<delivery>CO123456</delivery>";
        String bbb = "<delivery123>CO123456</delivery123>";
        Pattern p = Pattern.compile("(?<=<delivery>).*(?=</delivery>)");
        Matcher m1 = p.matcher(aaa);
        Matcher m2 = p.matcher(bbb);
        if (m1.find()) {
            System.out.println(m1.group(0));
        }
        if (m2.find()) {
            System.out.println(m2.group());
        }

        // 测试Stringbuilder的insert方法
        StringBuilder sb = new StringBuilder();
        int length = 10;
        while (sb.length() < length) {
            sb.insert(0, "0");
        }
        System.out.println(sb);

        // 测试时间戳毫秒和秒
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(Instant.now().getEpochSecond());


        // 校验密码长度，规则：8~20位（只是用来过渗透测试使用，无需国际化）
        String password = "Aa123123_4";
        boolean checkPasswordLength = PwdCheckUtils.checkPasswordLength(password, "8", "20");
        if (!checkPasswordLength) {
            System.out.println("密码长度不符合");
        }
        // 校验密码复杂度，规则：包含【大小写字母】、【数字】、【特殊字符】（只是用来过渗透测试使用，无需国际化）
        if (!checkPasswordComplexity(password)) {
            System.out.println("密码复杂度低");
        }

        // 校验合并空list
        List<String> mergeList = Lists.newArrayList();
        mergeList.addAll(Lists.newArrayList());
        mergeList.addAll(Lists.newArrayList());
        System.out.println(mergeList);

        // 测试number转换类
        NumberFormat numberFormat = getNumberFormat(2);
        System.out.println(numberFormat.format(123.45678));

        // localdatetime转date
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(Date.from(localDateTime1.atZone(ZoneId.systemDefault()).toInstant()));

        // 移除最后的逗号
        System.out.println(StringUtils.removeEnd("bbbb,aaaa,", ","));

        // 测试StringUtils.join
        System.out.println(StringUtils.join(Lists.newArrayList("a", "b", "c"), ";"));
        System.out.println(StringUtils.join("a", "b", "c"));


        // 测试list的add(index,element)方法，是否会覆盖第一个，结果：不会，是追加方式
        List<String> strList = Lists.newArrayList();
        strList.add(0, "a");
        strList.add(0, "b");
        System.out.println(strList);

        WeekFields wfs = WeekFields.of(DayOfWeek.SUNDAY, 4);
        // 2022-1-1 周六
        LocalDate nowLocalDate = LocalDate.of(2021, 12, 31).plusWeeks(1);
        int currentWeek = nowLocalDate.get(wfs.weekOfWeekBasedYear());
        System.out.println(currentWeek);

        System.out.println(LocalDate.of(2022,9,11).plusWeeks(1).plusWeeks(13));

        Calendar calendar = getCalendar();
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.WEEK_OF_YEAR, 52 + 1);
        System.out.println(calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        // 字符串排序
        LinkedList<String> linkedHashSet = Sets.newHashSet("5010","3000","2000","4000").stream().sorted().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(linkedHashSet);

        // 字符串获取最小
        List<String> factoryList = Lists.newArrayList("5010","3000","2000","4000");
        System.out.println(factoryList.stream().min(Comparator.comparing(x ->x)).get());

        // 字符串排序
        System.out.println(Lists.newArrayList("2022W41","2021W41","2022W31").stream().distinct().sorted().collect(Collectors.toList()));

        // 测试时间
        LocalDateTime start = LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime end = LocalDateTime.now().with(DayOfWeek.WEDNESDAY).withHour(20).withMinute(10).withSecond(0).withNano(0);
        System.out.println(start);
        System.out.println(end);

        // 物料按工厂排序
        MaterialCodeAndFactory materialCodeAndFactory1 = new MaterialCodeAndFactory("1-000000030", "3000");
        MaterialCodeAndFactory materialCodeAndFactory3 = new MaterialCodeAndFactory("8-600000046", "3000");
        MaterialCodeAndFactory materialCodeAndFactory2 = new MaterialCodeAndFactory("1-000000030", "2000");
        MaterialCodeAndFactory materialCodeAndFactory4 = new MaterialCodeAndFactory("8-600000046", "2000");
        MaterialCodeAndFactory materialCodeAndFactory5 = new MaterialCodeAndFactory("8-600000046", "5000");
        System.out.println(Lists.newArrayList(materialCodeAndFactory1,materialCodeAndFactory2,materialCodeAndFactory3,materialCodeAndFactory4,materialCodeAndFactory5).stream().sorted(Comparator.comparing(MaterialCodeAndFactory::getMaterialCode).thenComparing(MaterialCodeAndFactory::getFactory)).collect(Collectors.toList()));

        // StringUtils.substringAfterLast 截取字符串
        System.out.println(StringUtils.substringAfterLast("1-29292929/xxxx", "/"));

        // 获取上周天
        System.out.println(now.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)));
        // 获取当月第二个星期天
        System.out.println(now.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY)));

        // 测试json打印结果
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("saleUnit", 1);
        jsonObject.put("baseUnitNum", 1);
        jsonObject.put("minOrderQty", 1);
        System.out.println(JSONObject.toJSONString(jsonObject));
        jsonObject.put("saleUnit", 2);
        System.out.println(jsonObject.toJSONString());

        // 合并map
        Map<String,String> mergeMap = Maps.newHashMap();
        Map<String, String > aMap = Maps.newHashMap();
        aMap.put("a","b");
        Map<String, String > bMap = Maps.newHashMap();
        bMap.put("c","d");
        mergeMap.putAll(aMap);
        mergeMap.putAll(bMap);
        System.out.println(mergeMap);

        System.out.println(MATERIAL_CDOE_COMPILE.matcher("1-000000297").matches());
        System.out.println(MATERIAL_CDOE_COMPILE.matcher("202201041644").matches());


        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochSecond(1667260800L), ZoneId.systemDefault()).toLocalDate().until(LocalDate.now(), ChronoUnit.DAYS));

        // 正则
        String regex = ".{0,}BizException: WMS出库回调失败-接单失败.{0,}";
        System.out.println("xxxBizException: WMS出库回调失败-接单失败 wmsOutOrderEventContent={\"customerOrderNo\":\"SM20221101767696\",\"data\":{\"failReason\":\"E004:1747944420/6924922227366 批次可用数为0\"},\"wmsOrderNo\":\"\",\"wmsOutOrderStatus\":\"JIE_DAN_SHI_BAI\"}".matches(regex));


        String rs = "BizException: 创建wms调拨出库单失败，物料号6924922215660未维护";

        // 需求：从上面的内容中解析出 电话号码和邮箱。
        // 1、定义解析规则，字符串形式
        String regex2 = "BizException: 创建wms调拨出库单失败，物料号([0-9]{0,})未维护";


        // 3、把这个解析规则编译成匹配对象。，得到一个内容匹配器对象
        Matcher matcher = Pattern.compile(regex2).matcher(rs);

        // 4、开始找了
        while (matcher.find()) {
            String rs1 = matcher.group(1);
            System.out.println(rs1);
        }

        System.out.println(buildVersionPrefix());


        String prodTest = "SapException: 交货单0084081503过账失败！批量2303289999(物料1-000002497的)已经由PO_USER锁定交货单执行删除成功！";
        String rex = "([\\s\\S]*)PO_USER锁定([\\s\\S]*)";
        System.out.println(prodTest.matches(rex));

        // 使用BooleanUtils
        Boolean bool = null;
        System.out.println(BooleanUtils.isTrue(bool));

        // 测试json
        System.out.println(JSON.toJSONString(null));
        System.out.println(JSON.parseObject(null, User.class));
        System.out.println(StringUtils.removeEnd("测试一、下结尾、", "、"));

        System.out.println(JSONArray.parseArray("[{}]", User.class));

        Integer count1 = 10;
        Integer count2 = -5;
        System.out.println(count1 + count2);

        // 判断是否是数字
        Object obj = "29";
        Object obj2 = "0";
        Object obj3 = "0.1";
        System.out.println(StringUtils.isNumeric(obj.toString()));
        System.out.println(StringUtils.isNumeric(obj2.toString()));
        System.out.println(StringUtils.isNumeric(obj3.toString()));


        System.out.println(new BigDecimal("200").divide(BigDecimal.valueOf(0.55), 2, RoundingMode.HALF_UP));

        System.out.println(StringUtils.contains(null,"TBM"));

        User userA = new User();
        userA.setName("wangchen");
        userA.setTenantId("000000");
        userA.setUnionId(20000L);
        userA.setPrice(BigDecimal.valueOf(100L));

        User userB = new User();
        userB.setName("wangchen");
        userB.setTenantId("000000");
        userB.setUnionId(10000L);
        userB.setPrice(BigDecimal.valueOf(100.0));

        User userC = new User();
        userC.setName("wangchen");
        userC.setTenantId("123123");
        userC.setUnionId(10000L);
        userC.setPrice(BigDecimal.valueOf(123L));

        List<User> usersList = Lists.newArrayList(userA, userB, userC);

        UserUnique userUnique1 = UserUnique.builder().name("wangchen").tenantId("000000").price(BigDecimal.valueOf(100L)).build();
        UserUnique userUnique2 = UserUnique.builder().name("wangchen").tenantId("000000").price(BigDecimal.valueOf(100.0)).build();
        System.out.println(userUnique1.equals(userUnique2));

        Map<UserUnique, User> uniqueUserMap = Maps.newHashMap();
        for (User user : usersList) {
            UserUnique userUnique = UserUnique.builder().name(user.getName()).tenantId(user.getTenantId()).price(user.getPrice()).build();
            if (uniqueUserMap.containsKey(userUnique)) {
                uniqueUserMap.computeIfPresent(userUnique, (k,v) -> {
                    v.setUnionId(v.getUnionId() + user.getUnionId());
                    return v;
                });
            } else {
                uniqueUserMap.put(userUnique, user);
            }
        }
        System.out.println(JSON.toJSONString(uniqueUserMap));


        System.out.println(StringUtils.contains("100,200,300", "200"));
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class UserUnique {
        private String name;
        private String tenantId;
        private BigDecimal price;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserUnique userUnique = (UserUnique) o;
            return Objects.equals(this.name, userUnique.getName()) &&
                    Objects.equals(this.tenantId, userUnique.getTenantId()) &&
                    this.price.compareTo(userUnique.getPrice()) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.name, this.tenantId, this.price.compareTo(BigDecimal.ZERO));
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class MaterialCodeAndFactory {
        private String materialCode;
        private String factory;
    }

    public static String buildVersionPrefix() {
        Calendar c = getCalendar();
        c.setTime(new Date(1676131200000L));
        return String.format("%dW%s-", c.get(Calendar.YEAR), new DecimalFormat("00").format(c.get(Calendar.WEEK_OF_YEAR)));
    }

    public static Calendar getCalendar() {
        Calendar c = new GregorianCalendar();
        c.clear();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        c.setMinimalDaysInFirstWeek(4);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        return c;
    }

    private static void addaaaa(AtomicInteger aaaa) {
        aaaa.addAndGet(1);
    }

    private static NumberFormat getNumberFormat(Integer length) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        numberFormat.setMinimumIntegerDigits(length);
        numberFormat.setMaximumIntegerDigits(length);
        return numberFormat;
    }

    /**
     * 校验密码复杂度
     *
     * @param password 密码
     * @return true/false
     */
    private static boolean checkPasswordComplexity(String password) {
        return PwdCheckUtils.checkContainLowerCase(password) &&
                PwdCheckUtils.checkContainUpperCase(password) &&
                PwdCheckUtils.checkContainDigit(password) &&
                PwdCheckUtils.checkContainSpecialChar(password);
    }

    public static String timeOfLongToStr(long time) {
        Assert.notNull(time, "time is null");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time * 1000L), ZoneId.systemDefault()));
    }

    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @EqualsAndHashCode
    static class User {
        private Boolean exe;
        private Long unionId;
        private String name;
        private String tenantId;
        private BigDecimal price;
    }

    private static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }

    private static boolean isValidDates(String str) {
        if (!StringUtils.contains(str, "-")) {
            return false;
        }
        String[] strArr = StringUtils.split(str, "-");
        return Arrays.stream(strArr).allMatch(Test::isValidDate);
    }

    private static String getJsonForCode(String json, String code) {
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            return jsonObject.getString(code);
        } catch (Exception e) {
            return null;
        }
    }

    public static Long date2TimeStamp(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateStr).getTime();
        } catch (Exception e) {
            return null;
        }
    }

}
