/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atmatech.sac.controller;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author marcos
 */
public class HyperLinkTest {
  public void br(String url) {
      JFrame frame = new JFrame();
    Container contentPane = frame.getContentPane();
    final JEditorPane ep = new JEditorPane();
    try {
      ep.setPage(url);
    } catch (IOException e) {
      System.err.println("Bad URL: " + e);
      System.exit(-1);
    }
    HyperlinkListener listener = new HyperlinkListener() {
      public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
          try {
            ep.setPage(e.getURL());
          } catch (IOException ioe) {
            System.err.println("Error loading: " + ioe);
          }
        }
      }
    };
    ep.addHyperlinkListener(listener);
    ep.setEditable(false);
    JScrollPane pane = new JScrollPane(ep);
    contentPane.add(pane, BorderLayout.CENTER);
    frame.setSize(1024, 786);
    frame.show();
  }
}
