package com.example.demo.limit;

/**

 * <p>redis 限流类型</p>

 */
public enum LimitType {
	  /**

     * 自定义key

     */

    USER,

    /**

     * 根据请求者IP

     */

    IP;
}
