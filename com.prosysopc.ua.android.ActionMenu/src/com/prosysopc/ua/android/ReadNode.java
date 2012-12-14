package com.prosysopc.ua.android;

import java.io.Serializable;

import org.opcfoundation.ua.builtintypes.NodeId;

import com.prosysopc.ua.client.UaClient;


public class ReadNode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NodeId readNodeId;
	public UaClient myClient;
}
