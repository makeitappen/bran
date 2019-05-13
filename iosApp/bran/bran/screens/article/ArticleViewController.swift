//
//  ArticleViewController.swift
//  bran
//
//  Created by Roland Michelberger on 10.05.19.
//  Copyright © 2019 makeitappen GmbH. All rights reserved.
//

import UIKit
import Shared
import WebKit

class ArticleViewController: PresenterViewController {
    
    override internal var _presenter: Presenter { return presenter }
    var presenter: ArticlePresenter!
    
    @IBOutlet private weak var webView: WKWebView!
    @IBOutlet private weak var activityIndicator: UIActivityIndicatorView!

    override func viewDidLoad() {
        super.viewDidLoad()
        
        webView.navigationDelegate = self
    }
}

extension ArticleViewController: ArticleViewI {
    
    func show(news: News) {
        if let url = URL(string: news.link) {
            let request = URLRequest(url: url)
            webView.load(request)
        }
    }
    
    func stopLoading(news: News) {
        webView.stopLoading()
    }
}

extension ArticleViewController: WKNavigationDelegate {
    
    func webView(_ webView: WKWebView, didStartProvisionalNavigation navigation: WKNavigation!) {
        activityIndicator.startAnimating()
    }
    
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        activityIndicator.stopAnimating()
    }
}
