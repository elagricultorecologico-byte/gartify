/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import r2.m;

public class a
extends SQLiteOpenHelper {
    private static a h;
    private SQLiteDatabase g = this.getWritableDatabase();

    public a(Context context) {
        super(context, "matriculas.db", null, 3);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table matriculas (_id integer primary key autoincrement, matricula text, distintivo int, modelo_general text, modelo_especifico text, energia text, descripcion text, favorito integer, fecha text, fabricacion text, extra text)");
    }

    public static a j(Context context) {
        if (h == null) {
            h = new a(context);
        }
        return h;
    }

    public boolean A(m m2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("matricula", m2.h());
        contentValues.put("distintivo", Integer.valueOf((int)m2.b()));
        contentValues.put("modelo_general", m2.j());
        contentValues.put("modelo_especifico", m2.i());
        contentValues.put("energia", m2.c());
        contentValues.put("descripcion", m2.a());
        contentValues.put("favorito", Integer.valueOf((int)m2.e()));
        contentValues.put("fecha", m2.f());
        contentValues.put("fabricacion", m2.d());
        contentValues.put("extra", m2.g());
        SQLiteDatabase sQLiteDatabase = this.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select _id from matriculas where matricula = '");
        stringBuilder.append(m2.h());
        stringBuilder.append("'");
        if (!sQLiteDatabase.rawQuery(stringBuilder.toString(), null).moveToFirst()) {
            this.g.insert("matriculas", null, contentValues);
            return true;
        }
        sQLiteDatabase = this.g;
        stringBuilder = new StringBuilder();
        stringBuilder.append("matricula = '");
        stringBuilder.append(m2.h());
        stringBuilder.append("'");
        sQLiteDatabase.update("matriculas", contentValues, stringBuilder.toString(), null);
        return false;
    }

    public void f(String string) {
        SQLiteDatabase sQLiteDatabase = this.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delete from matriculas where matricula ='");
        stringBuilder.append(string);
        stringBuilder.append("'");
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    public m i(String object) {
        SQLiteDatabase sQLiteDatabase = this.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select _id,  matricula, distintivo, modelo_general, modelo_especifico, energia, descripcion, favorito, fecha, fabricacion, extra from matriculas where matricula = '");
        stringBuilder.append((String)object);
        stringBuilder.append("'");
        stringBuilder = sQLiteDatabase.rawQuery(stringBuilder.toString(), null);
        if (stringBuilder.moveToFirst()) {
            object = new m();
            ((m)object).q(stringBuilder.getInt(0));
            ((m)object).s(stringBuilder.getString(1));
            ((m)object).l(stringBuilder.getInt(2));
            ((m)object).u(stringBuilder.getString(3));
            ((m)object).t(stringBuilder.getString(4));
            ((m)object).m(stringBuilder.getString(5));
            ((m)object).k(stringBuilder.getString(6));
            ((m)object).o(stringBuilder.getInt(7));
            ((m)object).p(stringBuilder.getString(8));
            ((m)object).n(stringBuilder.getString(9));
            ((m)object).r(stringBuilder.getString(10));
            return object;
        }
        return null;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int n2, int n3) {
        sQLiteDatabase.execSQL("drop table matriculas");
        this.a(sQLiteDatabase);
    }

    public ArrayList p(int n2) {
        SQLiteDatabase sQLiteDatabase = this.g;
        Object object = new StringBuilder();
        object.append("select _id, matricula, distintivo, modelo_general, modelo_especifico, energia, descripcion, favorito, fecha, fabricacion, extra from matriculas where favorito = ");
        object.append(n2);
        object.append(" order by _id desc");
        Cursor cursor = sQLiteDatabase.rawQuery(object.toString(), null);
        if (cursor.moveToFirst()) {
            sQLiteDatabase = new ArrayList(cursor.getCount());
            do {
                object = new m();
                ((m)object).q(cursor.getInt(0));
                ((m)object).s(cursor.getString(1));
                ((m)object).l(cursor.getInt(2));
                ((m)object).u(cursor.getString(3));
                ((m)object).t(cursor.getString(4));
                ((m)object).m(cursor.getString(5));
                ((m)object).k(cursor.getString(6));
                ((m)object).p(cursor.getString(8));
                ((m)object).n(cursor.getString(9));
                ((m)object).r(cursor.getString(10));
                sQLiteDatabase.add(object);
            } while (cursor.moveToNext());
            return sQLiteDatabase;
        }
        return null;
    }
}

