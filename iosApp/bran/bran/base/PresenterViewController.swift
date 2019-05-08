//
//  PresenterViewController.swift
//  bran
//
//  Created by Roland Michelberger on 08.05.19.
//  Copyright © 2019 makeitappen GmbH. All rights reserved.
//

import UIKit
import Shared

protocol PresenterProtocol: ViewI {
    
    var _presenter: Presenter! { get }
    func set(presenter: Presenter)

}

class PresenterViewController: UIViewController, PresenterProtocol {
    
    internal var _presenter: Presenter!
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        _presenter.attach(view: self)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        _presenter.detach()
    }
    
    func set(presenter: Presenter) {
        _presenter = presenter
    }
    
}

class PresenterTabBarViewController: UITabBarController, PresenterProtocol {
    
    internal var _presenter: Presenter!

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)

        _presenter.attach(view: self)
    }

    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        _presenter.detach()
    }

    func set(presenter: Presenter) {
        _presenter = presenter
    }
    
}

class PresenterNavigationController: UINavigationController, PresenterProtocol {
    
    internal var _presenter: Presenter!
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        _presenter.attach(view: self)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        _presenter.detach()
    }
    
    func set(presenter: Presenter) {
        _presenter = presenter
    }
    
}
