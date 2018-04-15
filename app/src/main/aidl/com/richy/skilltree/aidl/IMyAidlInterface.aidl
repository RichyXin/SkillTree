// IMyAidlInterface.aidl
package com.richy.skilltree.aidl;
import com.richy.skilltree.aidl.Book;

interface IMyAidlInterface {
    String getInfo(String s);
    String getName(char name);

    //传递对象
    String getBook(in Book book);
}
