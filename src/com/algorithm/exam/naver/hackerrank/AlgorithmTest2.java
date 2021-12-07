package com.algorithm.exam.naver.hackerrank;

import java.util.*;


/**
 * 문제
 * 주어진 문자열 리스트에 대해 IP4이면 IPv4, IP6이면 IPv6, 둘다 아니먄 Neither를 출력하라
 * IPv4 예시: 127.0.0,1, 
 * IPv6 예시: ff0:123:123:123, 123::23
 * Neither 예시: 
 * 
 * https://hackerrankforwork.com>
 */

public class AlgorithmTest2 {
	public static void main(String[] args) {
		List<String> addresses = new ArrayList<String>();
		System.out.println(checkIpList(addresses));
	}


    public static List<String> checkIpList(List<String> addresses) {
    // Write your code here
        List<String> answer = new ArrayList<String>();
        for(String address: addresses){
            if(checkIPvP4(address)){
                answer.add("IPv4");
            }else if(checkIPvP6(address)){
                answer.add("IPv6");
            }else{
                answer.add("Neither");
            }
        }
        
        return answer;
    }
    
    public static boolean checkIPvP4(String ip){
        String[] ipv4 = ip.split("\\.");
        if(ipv4.length != 4 ){
            return false;
        }else{
            for(String mask: ipv4){
                try{
                    Integer tempMask = Integer.parseInt(mask);
                    if(tempMask == null || tempMask < 0 || tempMask > 255){
                        return false;
                    }
                }catch(Exception e){
                    return false;
                }
            }
            return true;
        }
    }
    
    public static boolean checkIPvP6(String ip){
        String[] ipv6 = ip.split(":");
        if(ipv6.length < 8){
            if(!ip.contains("::")){
                return false;
            }else{
                for(String mask: ipv6){
                    if(mask.length() == 0 || (Integer.parseInt(mask, 16) >= 0 && Integer.parseInt(mask, 16) <= 65536)){
                        
                    }else{
                        return false;
                    }
                }
                return true;
            }
        }else if(ipv6.length != 8 ){
            return false;
        }else{
            try{    
                for(String mask: ipv6){
                    Integer tempMast = Integer.parseInt(mask,16);
                    if(tempMast == null || tempMast < 0 || tempMast > 65536){
                        return false;
                    }
                }
                return true;
            }catch(Exception e){
                return false;
            }
        }
    }
}
