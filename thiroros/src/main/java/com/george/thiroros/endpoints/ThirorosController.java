package com.george.thiroros.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.george.thiroros.domain.Node;
import com.george.thiroros.services.ThirorosService;

@RestController
public class ThirorosController {

	@Autowired
	private ThirorosService thirorosService;

	@RequestMapping(path = "/thiroros", method = RequestMethod.POST)
	public String addNode(@RequestBody Node node) {
		Long id;
		try {
			id = thirorosService.addNode(node);
			return id.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RequestMapping(path = "/thiroros/{id}", method = RequestMethod.DELETE)
	public String removeNode(@PathVariable Long id) {
		try {
			thirorosService.removeNode(id);
			return "Node removed successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RequestMapping(path = "/thiroros", method = RequestMethod.GET)
	public List<Node> getNodes() {
		return thirorosService.getNodes();
	}

}
