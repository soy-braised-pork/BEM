package com.buildepidemicmonitoring.demo.entity;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaohan
 */

public class TcpConnectionPool {
    private ArrayList<Socket> arrayList = new ArrayList<>();
    private ArrayList<Integer> arr = new ArrayList<>();
    private String host;
    private int port;
    private Integer count = 0;
    private int captain;
    private int backFlag = 0;

    public TcpConnectionPool(int captain, String host, int port) {

        this.captain = captain;
        this.host = host;
        this.port = port;

    }

    public void init() throws IOException {

        for (int i = 0; i < captain; i++) {
            Socket socket = new Socket(host, port);
            arrayList.add(socket);
        }

    }

    public Map<Integer, Socket> getConnection() {

        if (count < arrayList.size()) {

            Socket socket = arrayList.get(count);
            Map<Integer, Socket> map = new HashMap<>();
            map.put(count, socket);
            count++;
            return map;

        } else if (backFlag != 0) {

            Integer flag = arr.get(0);
            arr.remove(0);
            backFlag--;
            Socket socket = arrayList.get(flag);
            Map<Integer, Socket> map = new HashMap<Integer, Socket>();
            map.put(flag, socket);
            return map;

        } else {

            Map<Integer, Socket> map = new HashMap<Integer, Socket>();
            map.put(null, null);
            return map;

        }

    }

    public void back(Integer flag) {

        if (backFlag >= captain) {
            backFlag = 0;
            backFlag++;
            arr.clear();
        } else {
            backFlag++;
        }
        arr.add(flag);

    }

}
