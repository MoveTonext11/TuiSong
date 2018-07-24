package com.jilin.example.ziang.tuisong.Utils;

import android.content.Context;

import com.jilin.example.ziang.tuisong.TjApp;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.List;

/**
 * 数据库工具类
 * 
 * @author liuhui
 *
 */
public class LiteOrmDBUtil {

	public static String DB_NAME;
	private static LiteOrm liteOrm;
	public static Context mContext;

	/**
	 * 数据库名称
	 * 
	 * @return
	 */
	private static String getUserDatabaseName() {
		return "ocall_info";
	}

	/**
	 * 创建级联数据库
	 * 
	 * @param context
	 */
	public static boolean createCascadeDB(Context context) {
		mContext = context.getApplicationContext();
		DB_NAME = getUserDatabaseName();
		liteOrm = LiteOrm.newCascadeInstance(mContext, DB_NAME);
		liteOrm.setDebugged(LogUtil.isDebuggable());
		return true;
	}

	public static LiteOrm getLiteOrm() {
		if (liteOrm == null) {
			if (mContext == null) {
				mContext = TjApp.getContext();
			}
			DB_NAME = getUserDatabaseName();
			liteOrm = LiteOrm.newCascadeInstance(mContext, DB_NAME);
			liteOrm.setDebugged(LogUtil.isDebuggable());
		}
		return liteOrm;
	}

	/**
	 * 插入一条记录
	 * 
	 * @param t
	 */
	public static <T> long insert(T t) {
		return getLiteOrm().save(t);
	}

	/**
	 * 查询所有
	 * 
	 * @param cla
	 * @return
	 */
	public static <T> List<T> getQueryAll(Class<T> cla) {
		return getLiteOrm().query(cla);
	}


	/**
	 * 查询 某字段 等于 Value的值
	 * 
	 * @param cla
	 * @param field
	 * @param value
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List<T> getQueryByWhere(Class<T> cla, String field,
                                              Object[] value) {
		return getLiteOrm().<T> query(
				new QueryBuilder(cla).where(field + "=?", value));
	}

	/**
	 * 删除所有
	 * 
	 * @param cla
	 */
	public static <T> int deleteAll(Class<T> cla) {
		return getLiteOrm().deleteAll(cla);
	}
}