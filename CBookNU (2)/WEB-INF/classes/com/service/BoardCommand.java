package com.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardCommand {

	public void executeBP(HttpServletRequest request, HttpServletResponse response) throws IOException;
	public void executeFB(HttpServletRequest request, HttpServletResponse response) throws IOException;
	public void executereport(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
