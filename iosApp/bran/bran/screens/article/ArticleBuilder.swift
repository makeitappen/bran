//
//  ArticleBuilder.swift
//  bran
//
//  Created by Roland Michelberger on 13.05.19.
//  Copyright © 2019 makeitappen GmbH. All rights reserved.
//

import UIKit
import Shared

class ArticleBuilder {

    class func instantiateViewController(news: News) -> ArticleViewController {
        
        let articleViewController: ArticleViewController = UIStoryboard(name: "Article").instantiateInitialViewController()
        let presenter = ArticlePresenter(articleRepository: ArticleRepository(news: news))
        articleViewController.presenter = presenter
        return articleViewController

    }
    
}
