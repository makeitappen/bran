//
//  NewsViewController.swift
//  bran
//
//  Created by Roland Michelberger on 10.05.19.
//  Copyright © 2019 makeitappen GmbH. All rights reserved.
//

import UIKit
import Shared

class NewsViewController: PresenterViewController {
    
    @IBOutlet private weak var tableView: UITableView!
    
    override internal var _presenter: Presenter { return presenter }    
    private let presenter = NewsPresenter(repository: NewsRepository())
    
    private var newsList = [News]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
}

extension NewsViewController: UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return newsList.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
        
        let news = newsList[indexPath.row]
        cell.textLabel?.text = news.title
        cell.detailTextLabel?.text = news.detail        
        
        return cell
    }
}

extension NewsViewController: UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let news = newsList[indexPath.row]
        presenter.onNewsSelected(news: news)
        
    }
}

extension NewsViewController: NewsViewI {
    
    func show(newsList: [News]) {
        self.newsList = newsList
        tableView.reloadData()
    }
    
    func showDetail(news: News) {
        let articleViewController: ArticleViewController = "Article".instantiateInitialViewController()
        articleViewController.news = news
        navigationController?.show(articleViewController, sender: nil)
    }
}
