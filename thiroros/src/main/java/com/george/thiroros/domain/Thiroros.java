package com.george.thiroros.domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class Thiroros {

	private ConcurrentHashMap<Long, Node> nodes;

	public Thiroros() {
		nodes = new ConcurrentHashMap<Long, Node>();
	}

	public Long addNode(Node node) throws Exception {
		Long id = 0L;
		try {
			id = computeId(node);
			if (nodes.containsKey(id)) {
				throw new Exception("Node already exists");
			}
			node.setId(id);
			nodes.put(id, node);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("Cannot create node", e);
		}
		return id;
	}

	public void removeNode(Long id) throws Exception {
		if (!nodes.containsKey(id)) {
			throw new Exception("No such Node");
		}
		nodes.remove(id);
	}

	public List<Node> getNodes() {
		List<Node> nodeList = new ArrayList<Node>();
		for (Node node : nodes.values()) {
			nodeList.add(node);
		}
		return nodeList;
	}

	private Long computeId(Node node) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
		byte[] digest = messageDigest.digest((node.getIp() + node.getPort()).getBytes());
		return byteArray2Integer(digest);
	}

	private Long byteArray2Integer(byte[] bytes) {
		long result = 0;
		for (int i = 0; i < 3; i++) {
			result += ((bytes[i] & 0xFF) << (i * 8));
		}
		result += ((bytes[3] & 0x7F) << (3 * 8));
		return result;
	}

}
