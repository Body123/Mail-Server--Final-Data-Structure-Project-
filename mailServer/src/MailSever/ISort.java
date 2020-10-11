package MailSever;

import library.doubleLinkedList;
import library.stackImplementation;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ISort {
	private String attributeOfSorting="";
    doubleLinkedList db=new doubleLinkedList();
    public ISort(String attributeOfSorting) {
        this.attributeOfSorting=attributeOfSorting;
    }
    public ISort(doubleLinkedList db) {
        this.db=db;
    }
    public doubleLinkedList sorting(doubleLinkedList  s  ) {
        // TODO Auto-generated method stub
        stackImplementation stack = new stackImplementation();
        stack.push(0);
        stack.push(s.size());
        while (!stack.isEmpty()) {
            int End = (int) stack.pop();
            int start = (int) stack.pop();
            if (End - start < 2) {
                continue;
            }
            int p = start + ((End - start) / 2);
            if(!attributeOfSorting.equals("")) p = partitionOne(s, p, start, End);
            else  p = partitionTwo(s, p, start, End);
            stack.push(p + 1);
            stack.push(End);
            stack.push(start);
            stack.push(p);
        }
        return s;
    }
    private int partitionOne(doubleLinkedList s, int pos, int start, int end) {
        int l = start;
        int h = end - 2;
        IMail q = (IMail) s.get(pos);
        IMail piv = q;
        Set<Boolean> validConditions = new HashSet<Boolean>();
        Set<Boolean> inverseValidConditions = new HashSet<Boolean>();
        swap(s, pos, end - 1 ,true);
        while (l < h) {
            IMail r = (IMail) s.get(l);
            IMail t = (IMail) s.get(h);
            validConditions.add((attributeOfSorting.equals("date"))&&(r.emailDate).compareTo(piv.emailDate)>=0);
            validConditions.add((attributeOfSorting.equals("Sender"))&&(r.Sender).compareToIgnoreCase(piv.Sender)<0);
            validConditions.add((attributeOfSorting.equals("Subject"))&&(r.Subject).compareToIgnoreCase(piv.Subject)<0);
            validConditions.add((attributeOfSorting.equals("Body"))&&(r.Body).compareToIgnoreCase(piv.Body)<0);
            inverseValidConditions.add((attributeOfSorting.equals("date"))&&(t.emailDate).compareTo(piv.emailDate)<0);
            inverseValidConditions.add((attributeOfSorting.equals("Sender"))&&(t.Sender).compareToIgnoreCase(piv.Sender)>=0);
            inverseValidConditions.add((attributeOfSorting.equals("Subject"))&&(t.Subject).compareToIgnoreCase(piv.Subject)>=0);
            inverseValidConditions.add((attributeOfSorting.equals("Body"))&&(t.Body).compareToIgnoreCase(piv.Body)>=0);
            if (validConditions.contains(true)) {
                l++;
            } else if (inverseValidConditions.contains(true)) {
                h--;
            } else {
                swap(s, l, h ,true);
            }
            validConditions.clear();
            inverseValidConditions.clear();
        }
        int index = h;
        IMail t = (IMail) s.get(h);
        validConditions.add((attributeOfSorting.equals("date"))&&(t.emailDate).compareTo(piv.emailDate)>=0);
        validConditions.add((attributeOfSorting.equals("Sender"))&&(t.Sender).compareToIgnoreCase(piv.Sender)<0);
        validConditions.add((attributeOfSorting.equals("Subject"))&&(t.Subject).compareToIgnoreCase(piv.Subject)<0);
        validConditions.add((attributeOfSorting.equals("Body"))&&(t.Body).compareToIgnoreCase(piv.Body)<0);
        if (validConditions.contains(true)) {
            index++;
        }
        swap(s,end - 1,index ,true);
        return index;
    }
    private void swap(doubleLinkedList s, int i, int j ,boolean flag) {
        if(flag) {
            IMail temp = (IMail) s.get(i);
            s.set(i,s.get(j));
            s.set(j,temp);
        } else {
            String temp = (String) s.get(i);
            s.set(i,s.get(j));
            s.set(j,temp);
        }
    }
    private int partitionTwo(doubleLinkedList s, int pos, int start, int end) {
        int l = start;
        int h = end - 2;
        String q = (String) s.get(pos);
        String piv = q;
        swap(s, pos, end - 1 ,false);
        while (l < h) {
            String  r = (String) s.get(l);
            String t = (String) s.get(h);
            if ((r).compareToIgnoreCase(piv) < 0) {
                l++;
            } else if ((t).compareToIgnoreCase(piv) >= 0) {
                h--;
            } else {
                swap(s, l, h ,false);
            }
        }
        int index = h;
        String t = (String) s.get(h);
        if (t.compareToIgnoreCase(piv) < 0) {
            index++;
        }
        swap(s, end - 1, index ,false);
        return index;
    }
}
